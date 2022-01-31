package it.training.spring;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT * FROM PERSON WHERE EMAIL=:email")
    List<Person> mySearch(@Param("email") String email);

    List<Person> findByEmail(String email);
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
}