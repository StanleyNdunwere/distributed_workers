package com.stanleyndunwere.distributed_workers.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Data
@Component
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String url;
  private String status;
  private String httpCode;
}
