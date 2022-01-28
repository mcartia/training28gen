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
    JdbcOperations jdbc;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyConfiguration.class,
                DbConfiguration.class);
        Main main = ctx.getBean(Main.class);
        main.run(args);
    }

    public void run(String[] args) {
        jdbc.execute("INSERT INTO person(id, firstName, lastName, email) VALUES(1,'Mario','Cartia','mario.cartia@gmail.com')");
        jdbc.execute("INSERT INTO person(id, firstName, lastName, email) VALUES(2,'Giuseppe','Rossi','giuseppe.rossi@gmail.com')");

        /*SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM person");
        System.out.println("Fetching data\n--------");
        while(rs.next()){
            System.out.println("id: "+rs.getInt("id"));
            System.out.println("first name: "+rs.getString("firstName"));
            System.out.println("last namne: "+rs.getString("lastName"));
            System.out.println("email: "+rs.getString("email"));
            System.out.println("--------");
        }*/

        List<Person> persons = jdbc.query("SELECT * FROM person",new PersonMapper());

        for (Person p : persons) {
            System.out.println("> "+p);
        }

    }
}
