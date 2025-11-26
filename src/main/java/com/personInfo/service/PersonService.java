package com.personInfo.service;

import com.personInfo.api.dto.PersonRequest;
import com.personInfo.api.dto.PersonResponse;
import com.personInfo.entity.Person;
import com.personInfo.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public PersonResponse register(PersonRequest req) {
        Person p = new Person();
        p.setName(req.getName());
        p.setAddress(req.getAddress());
        p.setPhoneNumber(req.getPhoneNumber());
        p.setAadharCard(req.getAadharCard());
        p.setEmail(req.getEmail());

        Person saved = repo.save(p);

        return mapToResponse(saved);
    }

    public PersonResponse getById(Long id) {
        Person p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return mapToResponse(p);
    }

    private PersonResponse mapToResponse(Person p) {
        PersonResponse res = new PersonResponse();
        res.setId(p.getId());
        res.setName(p.getName());
        res.setAddress(p.getAddress());
        res.setPhoneNumber(p.getPhoneNumber());
        res.setAadharCard(p.getAadharCard());
        res.setEmail(p.getEmail());
        res.setCreatedAt(p.getCreatedAt().toString());
        return res;
    }
}
