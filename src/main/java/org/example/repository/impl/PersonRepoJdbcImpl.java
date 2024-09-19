package org.example.repository.impl;

import org.example.entity.Person;
import org.example.repository.PersonRepository;

import java.util.List;

public class PersonRepoJdbcImpl implements PersonRepository {

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public Person update(Long id, Person newPerson) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public Person findByNameAndFamily(String name, String family) {
        return null;
    }

    @Override
    public Person findByPhoneNum(String phoneNum) {
        return null;
    }
}
