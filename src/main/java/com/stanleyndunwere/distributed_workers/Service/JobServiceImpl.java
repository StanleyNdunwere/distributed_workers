package com.stanleyndunwere.distributed_workers.Service;

import com.stanleyndunwere.distributed_workers.Models.Job;
import com.stanleyndunwere.distributed_workers.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

  private JobRepository jobRepo;

  @Autowired
  public JobServiceImpl(JobRepository jobRepo) {
    this.jobRepo = jobRepo;
  }

  @Override
  public List<Job> findAllJobs() {
    return jobRepo.findAll();
  }

  @Override
  public Job save(Job job) {
    return jobRepo.save(job);
  }

  @Override
  public List<Job> findJobsWithStatus(String status) {
    return jobRepo.findAllByStatus(status);
  }

  @Override
  public void updateJobStatus(String status, long jobId) {
    jobRepo.updateStatusOfJob(status, jobId);
  }

  @Override
  public int countJobsWithStatus(String status) {
    return jobRepo.getCountOfJobs(status);
  }

  @Override
  public Job findJobById(long id) {
    return jobRepo.findById(id);
  }

  @Override
  public Job findFirstJobWithStatus(String status) {
    return jobRepo.findFirstByStatusEquals(status);
  }

  @Override
  public void updateHttpCodeCompleterAndStatusOfJob(String status, String httpCode, String completer, long id) {
    jobRepo.updateHttpCodeCompleterAndStatusOfJob(status, httpCode, completer, id);
  }


}
