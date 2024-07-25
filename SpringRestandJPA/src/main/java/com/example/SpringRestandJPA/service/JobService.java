package com.example.SpringRestandJPA.service;

import com.example.SpringRestandJPA.model.JobPost;
import com.example.SpringRestandJPA.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void savejob(JobPost job)
    {
        repo.save(job);
    }

    public List<JobPost> getjobs() {
       return repo.findAll();
    }

    public JobPost findjobbyid(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }


    public void updatejobs(JobPost job) {
        repo.save(job);
    }

    public void deletejob(int postId)
    {
        repo.deleteById(postId);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContaining(keyword);
    }
}
