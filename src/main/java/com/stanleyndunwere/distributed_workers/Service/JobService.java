package com.stanleyndunwere.distributed_workers.Service;

import com.stanleyndunwere.distributed_workers.Models.Job;

import java.util.List;

public interface JobService {

  List<Job> findAllJobs();
}
