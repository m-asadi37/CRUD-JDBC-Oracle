package org.example.repository.impl;

import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.example.repository.base.DBConnect;

import java.sql.*;
import java.util.ArrayList;
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
        List<Person> personList = new ArrayList<>();

        try (DBConnect dbConnect = new DBConnect()) {
            Connection con = dbConnect.getConnection();

            PreparedStatement stm = con.prepareStatement("select * from PERSON");
            ResultSet set = stm.executeQuery();
            while (set.next()){
                long id = set.getLong(1);
                String name = set.getString(2);
                String family = set.getString(3);
                Date date = set.getDate(4);
                String email = set.getString(5);
                String phone = set.getString(6);
                String address = set.getString(7);
                Person p = new Person(id, name, family, date.toLocalDate(), email, phone, address);
                personList.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return personList;
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
