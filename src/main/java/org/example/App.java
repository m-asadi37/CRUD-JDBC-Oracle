package org.example;

import org.example.controller.PersonController;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;

public class App {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        PersonService service = new PersonService(repository);
        PersonController controller = new PersonController(service);

        controller.run();
    }
}