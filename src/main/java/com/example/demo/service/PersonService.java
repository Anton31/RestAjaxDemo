package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    /**
     adds new person to database
     */

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    /**
     updates one person in database
     */
    public void updatePerson(Person person){
        personRepository.save(person);
    }

    /**
     removes person to database
     */
    public void deletePerson(long id) {
        personRepository.delete(id);
    }

    /**
     gets all persons from database
     */
    public List<Person> listPersons() {
        return (List<Person>) personRepository.findAll();
    }

    /**
     gets one person from database
     */
    public Person getPerson(long id){
        return personRepository.findOne(id);
    }

}
