package com.matcha.controller;

import com.matcha.dao.PersonRepository;
import com.matcha.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public Object savePerson(@RequestBody PersonEntity personEntity) {
        personRepository.save(personEntity);
        return "ok";
    }
}
