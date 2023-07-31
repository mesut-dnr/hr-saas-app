package com.hr.saas.app.port.output.repository;

import com.hr.saas.domain.entity.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {

    Optional<Person> findPersonByPersonId(UUID personId);
}
