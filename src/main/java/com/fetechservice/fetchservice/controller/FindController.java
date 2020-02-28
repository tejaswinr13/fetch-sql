package com.fetechservice.fetchservice.controller;

import com.fetechservice.fetchservice.model.UserDetails;
import com.fetechservice.fetchservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @GetMapping(value = "/getpat/{id}")
    public List<UserDetails> findById(@PathVariable String id){

        return userDetailsRepository.findById(id);

    }
}
