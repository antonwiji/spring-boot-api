package com.learn.apicrud.service;

import com.learn.apicrud.entity.Person;
import com.learn.apicrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson() {
        var persons = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> persons.add(person));

        return persons;
    }

    public Person getPersonByid(int id){
        var personByid = personRepository.getPersonByid(id);

        return personByid;
    }
}
