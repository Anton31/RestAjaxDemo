package com.example.demo.restcontroller;



import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/rest")
public class Controller {

    @Autowired
    PersonService personService;



    @RequestMapping(value = "/person", method = RequestMethod.GET)

    public List<Person> allPersons() {



        return personService.listPersons();
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)

    public void addPerson(@RequestBody Person p) {

        personService.addPerson(p);



    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)

    public void deletePerson(@PathVariable long id) {

        personService.deletePerson(id);



    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)

    public Person getPerson(@PathVariable long id) {

        return personService.getPerson(id);



    }
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person) {

        personService.updatePerson(person);



    }

}

