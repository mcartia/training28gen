package it.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {

    @Autowired
    PersonRepository pRepo;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyConfiguration.class,
                DbConfiguration.class);
        Main main = ctx.getBean(Main.class);
        main.run(args);
    }

    public void run(String[] args) {
        Person p1 = new Person();
        p1.setFirstName("Mario");
        p1.setLastName("Cartia");
        p1.setEmail("mario.cartia@gmail.com");

        Person p2 = new Person();
        p2.setFirstName("Giuseppe");
        p2.setLastName("Rossi");
        p2.setEmail("giuseppe.rossi@gmail.com");

        pRepo.save(p1);
        pRepo.save(p2);

        System.out.println("mario.cartia@gmail.com: "+pRepo.mySearch("mario.cartia@gmail.com").size());
        System.out.println("pippo.pappo@yahoo.com: "+pRepo.mySearch("pippo.pappo@yahoo.com").size());

        for (Person p : pRepo.findByFirstName("Mario")) {
            System.out.println("> "+p);
        }
    }
}
