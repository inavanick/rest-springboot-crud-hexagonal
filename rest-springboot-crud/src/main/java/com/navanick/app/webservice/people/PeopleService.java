package com.navanick.app.webservice.people;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.navanick.lib.people.EntityNotFoundException;
import com.navanick.lib.people.Person;

/**
 * Service Facade Pattern. 
 * This simple service didn't need a facade due to it's simplicity. However, should 
 * the complexity grow over time, the facade abstraction layer is present.
 */
interface PeopleService {
    ResponseEntity<List<Person>> getPeople();
    ResponseEntity<Person> getPerson(int personId) throws EntityNotFoundException;
    ResponseEntity<Person> createPerson(String firstName, String lastName);
    ResponseEntity<Person> updatePerson(Person person) throws EntityNotFoundException;
    ResponseEntity<String> deletePerson(int personId) throws EntityNotFoundException;
}