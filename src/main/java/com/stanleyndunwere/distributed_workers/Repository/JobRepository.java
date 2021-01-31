package com.stanleyndunwere.distributed_workers.Repository;

import com.stanleyndunwere.distributed_workers.Models.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

  List<Job> findAllByStatus(String status);

  Job findById(long id);

  List<Job> findAll();

  Job findFirstByStatusEquals(String status);

  @Transactional
  @Modifying
  @Query(value = "UPDATE Job as j SET j.status = :status WHERE j.id= :id")
  void updateStatusOfJob(@Param("status") String status, @Param("id") long id);

  @Transactional
  @Query(value = "SELECT count(url) FROM Job WHERE status = :status")
  int getCountOfJobs(@Param("status") String status);

  @Transactional
  @Modifying
  @Query(value = "UPDATE Job as j SET j.status = :status, j.httpCode = :httpCode, j.completedBy = :by WHERE j.id= :id")
  void updateHttpCodeCompleterAndStatusOfJob(@Param("status") String status,
                                             @Param("httpCode") String httpCode, @Param("by") String by, @Param("id") long id);


}
