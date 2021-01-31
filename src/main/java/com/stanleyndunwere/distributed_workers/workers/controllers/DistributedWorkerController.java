package com.stanleyndunwere.distributed_workers.workers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DistributedWorkerController {


  public String GetHomePage(){
    return "index";
  }

}


