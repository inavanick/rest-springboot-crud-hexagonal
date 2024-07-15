package com.navanick.app.webservice.people;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navanick.lib.people.EntityNotFoundException;
import com.navanick.lib.people.PeopleRepository;
import com.navanick.lib.people.Person;

@Service
class PeopleServiceImpl implements PeopleService {
    private PeopleRepository peopleRepository;

    PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public ResponseEntity<List<Person>> getPeople() {
        return ResponseEntity.ok(peopleRepository.getPeople());
    }

    @Override
    public ResponseEntity<Person> getPerson(int personId) throws EntityNotFoundException {
        return ResponseEntity.ok(peopleRepository.getPerson(personId));
    }

    @Override
    public ResponseEntity<Person> createPerson(String firstName, String lastName) {
        Person newPerson = peopleRepository.createPerson(firstName, lastName);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPerson);
    }

    @Override
    public ResponseEntity<Person> updatePerson(Person person) throws EntityNotFoundException {
        Person newPerson = peopleRepository.updatePerson(person);
        return ResponseEntity.ok(newPerson);
    }

    @Override
    public ResponseEntity<String> deletePerson(int personId) throws EntityNotFoundException {
        peopleRepository.deletePerson(personId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
