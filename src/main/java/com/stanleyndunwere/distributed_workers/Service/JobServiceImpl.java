package com.stanleyndunwere.distributed_workers.Service;

import com.stanleyndunwere.distributed_workers.Models.Job;
import com.stanleyndunwere.distributed_workers.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobServiceImpl implements JobService{

  private JobRepository jobRepo;

  @Autowired
  public JobServiceImpl(JobRepository jobRepo) {
    this.jobRepo = jobRepo;
  }

  @Override
  public List<Job> findAllJobs() {
    return null;
  }
}
