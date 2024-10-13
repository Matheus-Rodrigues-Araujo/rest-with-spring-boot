package com.rest_with_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest_with_spring_boot.models.Person;
public interface PersonRepository extends JpaRepository<Person, Long> { }
