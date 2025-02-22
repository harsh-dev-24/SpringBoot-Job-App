package com.harsh.jobapp.controller;


import com.harsh.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    //Constructor Injection
    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/jobs")
    public List<Job> findAllJobs(){
        return jobService.findAllJobs();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully!!!";
    }

    @PutMapping("/jobs/{id}")
    public Job updateJob(@RequestBody Job job, @PathVariable int id){
        return jobService.updateJob(job, id);
    }

    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable int id){
        jobService.deleteJob(id);
        return "Job deleted successfully!!!";
    }
}
