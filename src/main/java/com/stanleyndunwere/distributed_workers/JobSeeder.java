package com.stanleyndunwere.distributed_workers;

import com.stanleyndunwere.distributed_workers.Models.Job;
import com.stanleyndunwere.distributed_workers.Repository.JobRepository;
import com.stanleyndunwere.distributed_workers.Service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobSeeder implements CommandLineRunner {
  @Autowired
  private JobServiceImpl jobService;


  @Override
  public void run(String... args) throws Exception {
    final List<Job> jobs = new ArrayList<>();
    Job job1 = new Job("https://google.com", "NEW", "null");
    Job job2 = new Job("https://facebook.com", "NEW", "null");
    Job job3 = new Job("https://yahoo.com", "NEW", "null");
    Job job4 = new Job("https://instagram.com", "NEW", "null");
    Job job5 = new Job("https://snapchat.com", "NEW", "null");
    Job job6 = new Job("https://proxify.com", "NEW", "null");
    Job job7 = new Job("https://stackoverflow.com", "NEW", "null");
    jobs.add(job1);
    jobs.add(job2);
    jobs.add(job3);
    jobs.add(job4);
    jobs.add(job5);
    jobs.add(job6);
    jobs.add(job7);

    for (Job job : jobs) {
      jobService.save(job);
    }

  }
}

