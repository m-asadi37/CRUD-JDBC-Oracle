package org.example.repository.impl;

import org.example.entity.Person;
import org.example.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepoJavaImpl implements PersonRepository {
    private List<Person> persons = new ArrayList<>();
    private Long currentId = 1L;

    public Person save(Person person) {
        person.setId(currentId++);
        persons.add(person);
        return person;
    }

    public boolean update(Long id, Person newPerson) {
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                person.setName(newPerson.getName());
                person.setFamily(newPerson.getFamily());
                person.setBirthDate(newPerson.getBirthDate());
                person.setEmail(newPerson.getEmail());
                person.setPhoneNumber(newPerson.getPhoneNumber());
                person.setAddress(newPerson.getAddress());
                return true;
            }
        }
        return false;
    }

    public boolean delete(Long id) {
        return persons.removeIf(person -> person.getId().equals(id));
    }

    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    public Person findById(Long id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Person findByNameAndFamily(String name, String family) {
        return persons.stream()
                .filter(person -> person.getName().equals(name) && person.getFamily().equals(family))
                .findFirst()
                .orElse(null);
    }

    public Person findByPhoneNum(String phoneNum) {
        return persons.stream()
                .filter(person -> person.getPhoneNumber().equals(phoneNum))
                .findFirst()
                .orElse(null);
    }
}
