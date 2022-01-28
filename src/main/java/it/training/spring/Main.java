package it.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    MyBean myBean;

    @Autowired
    MyOtherBean myOtherBean;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Main main = ctx.getBean(Main.class);
        main.run(args);
    }

    public void run(String[] args) {
        System.out.println("La somma di 10 + 2 = "+myBean.sum(10,2));
    }
}
