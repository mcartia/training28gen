package it.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void savePersons(List<Person> persons) {
        for (Person p : persons) {
            if (new Random().nextInt(100)>90) {
                int a = 80/0;
            }
            System.out.println("Saving "+p+"...");
            personRepository.save(p);
        }
    }

}
