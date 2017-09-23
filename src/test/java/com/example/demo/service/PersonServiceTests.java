package com.example.demo.service;


import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTests {

    @InjectMocks
    private PersonService personService = new PersonService();

    @Mock
    private PersonRepository personRepository;
    List<Person> persons = new ArrayList<>();
    Person person1;
    Person person2;


    @Before
    public void setup() {
        person1 = new Person("Anton", 32, 180, 90);
        person1.setId(1L);
        person2 = new Person("Igor", 31, 190, 90);
        person2.setId(2L);
        persons.add(person1);
        persons.add(person2);


    }

    @Test
    public void getAllPersonsTest() {
        when(personRepository.findAll()).thenReturn(persons);
        assertEquals(personService.listPersons(), persons);
        verify(personRepository).findAll();

    }

    @Test
    public void getOnePersonTest() {

        when(personRepository.findOne(1L)).thenReturn(person1);
        assertEquals(personService.getPerson(1L), person1);
        verify(personRepository).findOne(1L);
    }

    @Test
    public void addPersonTest() {
        Person person3 = new Person("John", 40, 175, 75);

        personService.addPerson(person3);
        verify(personRepository).save(person3);
    }

    @Test
    public void deletePersonTest(){

        personService.deletePerson(1L);
        verify(personRepository).delete(1L);
    }

}
