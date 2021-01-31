package com.stanleyndunwere.distributed_workers.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String url;
  private String status;
  private String httpCode;
  private String completedBy;

  public Job(){

  }

  public Job(String url, String status, String httpCode) {
    this.url = url;
    this.status = status;
    this.httpCode = httpCode;

  }

}
