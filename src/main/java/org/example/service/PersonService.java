package org.example.service;

import org.example.entity.Person;
import org.example.repository.PersonRepository;

import java.util.List;

public class PersonService {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person person) throws Exception {
        if (repository.findByNameAndFamily(person.getName(), person.getFamily()) != null) {
            throw new Exception("A person with the same name and family already exists.");
        }
        if (repository.findByPhoneNum(person.getPhoneNumber()) != null) {
            throw new Exception("This phone number is already associated with another person.");
        }
        if (person.getPhoneNumber().length() != 11) {
            throw new Exception("The phone number must be 11 digits.");
        }
        return repository.save(person);
    }

    public boolean update(Long id, Person newPerson) throws Exception {
        if (newPerson.getPhoneNumber().length() != 11) {
            throw new Exception("The phone number must be 11 digits.");
        }
        return repository.update(id, newPerson);
    }

    public boolean delete(Long id) {
        return repository.delete(id);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id);
    }

    public Person findByNameAndFamily(String name, String family) {
        return repository.findByNameAndFamily(name, family);
    }

    public Person findByPhoneNum(String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }
}