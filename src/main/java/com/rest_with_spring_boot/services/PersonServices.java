package com.rest_with_spring_boot.services;

import com.rest_with_spring_boot.exceptions.ResourceNotFoundException;
import com.rest_with_spring_boot.models.Person;
import com.rest_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update person's data");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Delete person's data");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

}
