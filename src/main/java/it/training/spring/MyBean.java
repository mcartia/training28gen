package it.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MyBean {

    @Autowired
    MyBean self;

    public MyBean() {
        super();
    }

    @MyAudit
    public int sum(int a, int b) {
        System.out.println("inside MyBean.sum(..)");
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    @Cacheable(value = "default")
    public String myVeryLongOperation(String salt) {
        System.out.println("myVeryLongOperation... ("+salt+")");
        try {
        Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return UUID.randomUUID().toString();
    }

    public String test(String salt) {
        return self.myVeryLongOperation(salt);
    }

}
