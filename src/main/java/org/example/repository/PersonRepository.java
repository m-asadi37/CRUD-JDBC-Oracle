package org.example.repository;

import org.example.entity.Person;

import java.util.List;

public interface PersonRepository {

    Person save(Person person);
    boolean update(Long id, Person newPerson);
    boolean delete(Long id);
    List<Person> findAll();
    Person findById(Long id);
    Person findByNameAndFamily(String name, String family);
    Person findByPhoneNum(String phoneNum);


    }
