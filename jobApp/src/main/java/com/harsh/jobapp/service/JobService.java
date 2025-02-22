package com.harsh.jobapp.service;


import com.harsh.jobapp.controller.Job;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    List<Job> findAllJobs();

    void createJob(Job job);

    Job updateJob(Job job, Integer id);

    void deleteJob(Integer id);


}
