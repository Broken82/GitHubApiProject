package com.broken.githubapiproject.controller;

import com.broken.githubapiproject.model.Response;
import com.broken.githubapiproject.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/api/repos/{username}")
    public List<Response> repos(@PathVariable String username){
        return dataService.fetchAllRepos(username);

    }
}
