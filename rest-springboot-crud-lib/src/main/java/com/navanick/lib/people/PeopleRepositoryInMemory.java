package com.navanick.lib.people;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class PeopleRepositoryInMemory implements PeopleRepository {
    private List<Person> people = new ArrayList<>();
    private AtomicInteger personIdCtr = new AtomicInteger(3);
    private static final String UNABLE_TO_FIND_PERSON_WITH_ID = "Unable to locate the person with ID of %d";

    public PeopleRepositoryInMemory() {
        people.add(new Person(0, "John", "Doe"));
        people.add(new Person(1, "Jane", "Doe"));
        people.add(new Person(2, "Larry", "Johnson"));
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Person getPerson(int personId) throws EntityNotFoundException {
        Person person = null;
        try {
            person = people.get(personId);
        } catch (IndexOutOfBoundsException e) {
            throw new EntityNotFoundException(getEntityNotFoundExceptionMessage(personId));
        }
        return person;
    }

    @Override
    public Person createPerson(String firstName, String lastName) {
        int personId = personIdCtr.getAndIncrement();
        Person newPerson = new Person(personId, firstName, lastName);
        people.add(newPerson);
        return newPerson;
    }

    @Override
    public Person updatePerson(Person person) throws EntityNotFoundException {
        Person newPerson = new Person(person.personId(), person.firstName(), person.lastName());
        try {
            people.set(person.personId(), newPerson);
        } catch (IndexOutOfBoundsException e) {
            throw new EntityNotFoundException(getEntityNotFoundExceptionMessage(person.personId()));
        }
        return newPerson;
    }

    @Override
    public boolean deletePerson(int personId) throws EntityNotFoundException {
        Person newPerson = new Person(personId, null, null);
        try {
            people.set(personId, newPerson);
        } catch (IndexOutOfBoundsException e) {
            throw new EntityNotFoundException(getEntityNotFoundExceptionMessage(personId));
        }
        return true;
    }

    private String getEntityNotFoundExceptionMessage(int personId) {
        return String.format(UNABLE_TO_FIND_PERSON_WITH_ID, personId);
    }
}