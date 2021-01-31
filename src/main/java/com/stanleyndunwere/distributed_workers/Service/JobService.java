package com.stanleyndunwere.distributed_workers.Service;

import com.stanleyndunwere.distributed_workers.Models.Job;

import java.util.List;

public interface JobService {

  List<Job> findAllJobs();

  Job findJobById(long id);

  Job save(Job job);

  List<Job> findJobsWithStatus(String status);

  void updateJobStatus(String status, long jobId);

  int countJobsWithStatus(String status);

  Job findFirstJobWithStatus(String status);

  void updateHttpCodeCompleterAndStatusOfJob(String status, String httpCode,String completer, long id);
}
