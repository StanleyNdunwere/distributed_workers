package com.stanleyndunwere.distributed_workers.Repository;

import com.stanleyndunwere.distributed_workers.Models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

  List<Job> findAllByStatus(String status);

}
