package com.personInfo.controller;

import com.personInfo.api.dto.PersonRequest;
import com.personInfo.api.dto.PersonResponse;
import com.personInfo.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) {
        this.service = service;
    }
    @PostMapping
    public PersonResponse register(@RequestBody PersonRequest request) {
        return service.register(request);
    }
    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable Long id) {
        return service.getById(id);
    }
}
