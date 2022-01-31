package it.training.spring;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonGenerator {

    Faker faker;

    public PersonGenerator() {
        super();
        this.faker = new Faker();
    }

    public Person buildPerson() {
        Person p = new Person();
        String firstName = this.faker.name().firstName();
        String lastName = this.faker.name().lastName();
        String email = (firstName+"."+lastName+"@"+faker.internet().domainName()).toLowerCase();

        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);

        return p;
    }

    public List<Person> buildPersons(int num) {
        List<Person> persons = new ArrayList<Person>();
        for (int i=0; i<num; i++) {
            persons.add(buildPerson());
        }
        return persons;
    }

}
