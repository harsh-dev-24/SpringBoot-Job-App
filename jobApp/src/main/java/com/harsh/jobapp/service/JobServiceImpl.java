package com.harsh.jobapp.service;

import com.harsh.jobapp.controller.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>(List.of(
            new Job(1, "Java Developer", "Java SpringBoot Developer with minimum 3 YOE", "800000", "1200000", "Mumbai", "active"),
            new Job(2, "Python Developer", "Python Django Developer with minimum 2 YOE", "100000", "1300000", "Pune", "active"),
            new Job(3, "Frontend Developer", "Frontend React Developer with minimum 2 YOE", "700000", "1100000", "Bangalore", "active"),
            new Job(4, "Software Engineer (Fresher)", "Software Engineer with good coding skills", "400000", "700000", "Noida", "active"))
    );


    @Override
    public List<Job> findAllJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    @Override
    public Job updateJob(Job job, Integer id) {
        if(id == null){
            throw new IllegalArgumentException("Job id cannot be null");
        }else{
        Job fetchJob = jobs.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if(fetchJob != null){
            fetchJob.setDescription(job.getDescription());
            fetchJob.setTitle(job.getTitle());
            fetchJob.setLocation(job.getLocation());
            fetchJob.setStatus(job.getStatus());
            fetchJob.setMinSalary(job.getMinSalary());
            fetchJob.setMaxSalary(job.getMaxSalary());
        }else{
            throw new RuntimeException("Job ID not found!!");
        }
            return fetchJob;
        }

    }

    @Override
    public void deleteJob(Integer id) {
        Job job = jobs.stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Job ID not found!"));
        jobs.remove(job);
    }
}
