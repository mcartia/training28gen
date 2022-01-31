package it.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {

    @Autowired
    PersonRepository pRepo;

    @Autowired
    PersonGenerator personGenerator;

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyConfiguration.class,
                DbConfiguration.class);
        Main main = ctx.getBean(Main.class);
        main.run(args);
    }

    public void run(String[] args) {
        try {
            personService.savePersons(personGenerator.buildPersons(50));
        } catch (Exception e) {
            System.err.println("Si è verificato un errore...");
        }

        System.out.println("Record(s) on DB table: "+personRepository.count());

    }
}

