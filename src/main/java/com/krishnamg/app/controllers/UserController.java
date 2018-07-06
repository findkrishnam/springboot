package com.krishnamg.app.controllers;

import com.krishnamg.app.dao.UserDAO;
import com.krishnamg.app.model.System;
import com.krishnamg.app.service.AWSSecretsService;
import com.krishnamg.app.service.impl.AWSSecretServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    AWSSecretsService awsSecretsService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping(value = "/systems")
    public List<System> getAllUsers(){
        return userDAO.findAll();
    }

    @GetMapping(value = "/system/{id}")
    public System getAllUsers(@PathVariable Long id){
        return userDAO.findOne(id);
    }

    @GetMapping(value = "/connect")
    public String getDBName(){
        return namedParameterJdbcTemplate.queryForObject("select database()", new HashMap<>(), String.class);
    }

    @GetMapping(value = "/user")
    public String getUser(){
        return namedParameterJdbcTemplate.queryForObject("select user();", new HashMap<>(), String.class);
    }

    @GetMapping(value = "/secret")
    public String rotateSecret(){
        return awsSecretsService.getSecret();
    }

}
