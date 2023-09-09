package com.learn.apicrud.controller;

import com.learn.apicrud.entity.Person;
import com.learn.apicrud.response.ResponseHandler;
import com.learn.apicrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    private ResponseEntity<Object> getAllPerson(){
        try {
            var persons = personService.getAllPerson();
            return ResponseHandler.generateResponse("success", HttpStatus.OK, persons);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/persons")
    private ResponseEntity<Object> getPersonByid(@RequestBody Person personId){
        try {
            var personById = personService.getPersonByid(personId.getId());
            if (personById == null){
                return ResponseHandler.generateResponse("id not found", HttpStatus.NOT_FOUND, null);
            }
            return ResponseHandler.generateResponse("success", HttpStatus.OK, personById);
        } catch (Exception e){
          return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
