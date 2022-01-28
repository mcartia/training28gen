package it.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyOtherBean {

    @Autowired
    MyOtherBean self;

    @Autowired
    String hello;

    public MyOtherBean() {
        super();
    }

    @MyAudit
    public void test() {
        System.out.println("This is a test!");
    }

    public void test2() {
        System.out.println("Hello: "+hello);
    }

}
