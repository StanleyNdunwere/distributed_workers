package com.stanleyndunwere.distributed_workers.workers.controllers;

import com.stanleyndunwere.distributed_workers.Models.Job;
import com.stanleyndunwere.distributed_workers.Service.JobServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
@Slf4j
public class DistributedWorkerController {

  public static final String NEW = "NEW";
  public static final String PROCESSING = "PROCESSING";
  public static final String DONE = "DONE";
  public static final String ERROR = "ERROR";

  @Autowired
  private JobServiceImpl jobService;
  @Autowired
  private SimpMessagingTemplate template;


  @GetMapping("/")
  public String GetHomePage(Model jobs) {
    jobs.addAttribute("jobsList", jobService.findAllJobs());
    return "index";
  }

  @MessageMapping("/job")
  public void startJobUpdates(String processorName) throws InterruptedException {
    boolean newJobsAvailable = jobService.countJobsWithStatus(NEW) > 0;
    do {
      Thread.sleep(2000);
      log.info("logged here : about to start processing new job  " + processorName);
      Job latestJob = jobService.findFirstJobWithStatus(NEW);
      if (latestJob == null) {
        return;
      } else {
        jobService.updateJobStatus(PROCESSING, latestJob.getId());
        this.template.convertAndSend("/job/updates", jobService.findJobById(latestJob.getId()));
        String url = latestJob.getUrl();
        //perform get request and log header
        HttpHeaders headers = new HttpHeaders();
        try {
          RestTemplate restTemplate = new RestTemplate();
          HttpEntity entity = new HttpEntity(headers);
          ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
          int statusCode = response.getStatusCode().value();
          jobService.updateHttpCodeCompleterAndStatusOfJob(DONE, String.valueOf(statusCode), processorName, latestJob.getId());
        } catch (Exception ex) {
          jobService.updateHttpCodeCompleterAndStatusOfJob(ERROR, "N/A", processorName, latestJob.getId());
        }
      }
      this.template.convertAndSend("/job/updates", jobService.findJobById(latestJob.getId()));
    } while (newJobsAvailable);
  }
}




