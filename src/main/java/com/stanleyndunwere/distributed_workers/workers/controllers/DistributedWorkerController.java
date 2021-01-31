package com.stanleyndunwere.distributed_workers.workers.controllers;

import com.stanleyndunwere.distributed_workers.Service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DistributedWorkerController {

  @Autowired
  private JobServiceImpl jobService;

  public String GetHomePage(Model jobs){
    jobs.addAttribute("jobsList", jobService.findAllJobs());
    return "index";
  }

}


