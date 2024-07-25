package com.example.SpringRestandJPA.service;

import com.example.SpringRestandJPA.model.User;
import com.example.SpringRestandJPA.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u=repo.findByUsername(username);
        if(u==null)
        {
            throw new UsernameNotFoundException("no user");
        }

        return new UserDetailsImplm(u);
    }
}
