package com.example.SpringRestandJPA.controller;

import com.example.SpringRestandJPA.model.JobPost;
import com.example.SpringRestandJPA.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping("jobs")
    @ResponseBody
    public String addjob(@RequestBody JobPost job)
    {
        service.savejob(job);
        return "Saved";
    }

    @GetMapping("jobs")
    @ResponseBody
    public List<JobPost> getalljobs()
    {
        return service.getjobs();
    }

    @GetMapping("jobs/{postId}")
    @ResponseBody
    public JobPost getjobbyid(@PathVariable int postId){
        return service.findjobbyid(postId);
    }

    @PutMapping("jobs")
    @ResponseBody
    public String updatejob(@RequestBody JobPost job)
    {
        service.updatejobs(job);
        return "Updated";
    }

    @DeleteMapping("jobs/{postId}")
    @ResponseBody
    public String deletejobpost(@PathVariable int postId)
    {
        service.deletejob(postId);
        return "Deleted";
    }

    @GetMapping("jobs/keywords/{keyword}")
    @ResponseBody
    public List<JobPost> searchbbykeyword(@PathVariable String keyword)
    {
        return service.search(keyword);
    }

}
