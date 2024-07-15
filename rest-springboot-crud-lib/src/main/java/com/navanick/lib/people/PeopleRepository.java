package com.navanick.lib.people;

import java.util.List;

public interface PeopleRepository {
    public List<Person> getPeople();
    public Person getPerson(int personId) throws EntityNotFoundException;
    public Person createPerson(String firstName, String lastName);
    public Person updatePerson(Person person) throws EntityNotFoundException;
    public boolean deletePerson(int personId) throws EntityNotFoundException;
    public static PeopleRepository creaPeopleRepository() {
        return createPeopleRepository(PeopleRepositoryTypes.IN_MEMORY);
    }
    public static PeopleRepository createPeopleRepository(PeopleRepositoryTypes pAdapters) {
        // switch (pAdapters) {
        //     case IN_MEMORY -> {return new PeopleRepositoryInMemory();}
        //     case MYSQL -> {throw new UnsupportedOperationException("MYSQL is not supported yet");}
        // }
        switch (pAdapters) {
            case IN_MEMORY:
                return new PeopleRepositoryInMemory();
            default:
                throw new UnsupportedOperationException("MYSQL is not yet supported");
        }
    }
}