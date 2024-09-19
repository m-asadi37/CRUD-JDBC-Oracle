package org.example.controller;

import org.example.entity.Person;
import org.example.service.PersonService;

import java.util.Scanner;

public class PersonController {
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Person");
            System.out.println("2. Update Person");
            System.out.println("3. Delete Person");
            System.out.println("4. List All Persons");
            System.out.println("5. Find Person by ID");
            System.out.println("6. Find Person by Name and Family");
            System.out.println("7. Find Person by Phone Number");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addPerson(scanner);
                        break;
                    case 2:
                        updatePerson(scanner);
                        break;
                    case 3:
                        deletePerson(scanner);
                        break;
                    case 4:
                        listAllPersons();
                        break;
                    case 5:
                        findPersonById(scanner);
                        break;
                    case 6:
                        findPersonByNameAndFamily(scanner);
                        break;
                    case 7:
                        findPersonByPhoneNumber(scanner);
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addPerson(Scanner scanner) throws Exception {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Family: ");
        String family = scanner.nextLine();
        System.out.print("Enter Birth Date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Person person = new Person(null, name, family, birthDate, email, phoneNumber, address);
        service.save(person);
        System.out.println("Person added successfully.");
    }

    private void updatePerson(Scanner scanner) throws Exception {
        System.out.print("Enter ID of the person to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); 

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Family: ");
        String family = scanner.nextLine();
        System.out.print("Enter New Birth Date: ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter New Address: ");
        String address = scanner.nextLine();

        Person newPerson = new Person(id, name, family, birthDate, email, phoneNumber, address);
        service.update(id, newPerson);
        System.out.println("Person updated successfully.");
    }

    private void deletePerson(Scanner scanner) {
        System.out.print("Enter ID of the person to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        if (service.delete(id)) {
            System.out.println("Person deleted successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

    private void listAllPersons() {
        for (Person person : service.findAll()) {
            System.out.println(person);
        }
    }

    private void findPersonById(Scanner scanner) {
        System.out.print("Enter ID of the person to find: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Person person = service.findById(id);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }

    private void findPersonByNameAndFamily(Scanner scanner) {
        System.out.print("Enter Name of the person: ");
        String name = scanner.nextLine();
        System.out.print("Enter Family of the person: ");
        String family = scanner.nextLine();

        Person person = service.findByNameAndFamily(name, family);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }

    private void findPersonByPhoneNumber(Scanner scanner) {
        System.out.print("Enter Phone Number of the person: ");
        String phoneNumber = scanner.nextLine();

        Person person = service.findByPhoneNum(phoneNumber);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }
}