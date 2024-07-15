package com.navanick.app.webservice.people;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navanick.lib.people.Person;

@Controller
@RequestMapping("/people")
class PeopleController {
    private PeopleService peopleService;

    PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    ResponseEntity<List<Person>> getPeople() {
        return peopleService.getPeople();
    }

    @GetMapping("/{personId}")
    ResponseEntity<Person> getPerson(@PathVariable int personId) {
        return peopleService.getPerson(personId);
    }

    @PostMapping
    ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return peopleService.createPerson(person.firstName(), person.lastName());
    }

    @PutMapping("/{personId}")
    ResponseEntity<Person> updatePerson(@PathVariable int personId, @RequestBody Person person) {
        return peopleService.updatePerson(
            new Person(personId, person.firstName(), person.lastName())
        );
    }

    @DeleteMapping("/{personId}")
    ResponseEntity<String> deletePerson(@PathVariable int personId) {
        return peopleService.deletePerson(personId);
    }
}