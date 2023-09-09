package com.learn.apicrud.repository;

import com.learn.apicrud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>, JpaRepository<Person, Integer> {
    @Query(value = "SELECT * FROM person WHERE id = :id", nativeQuery = true)
    Person getPersonByid(int id);
}
