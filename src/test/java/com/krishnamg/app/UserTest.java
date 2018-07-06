package com.krishnamg.app;

import com.krishnamg.app.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(JUnit4.class)
public class UserTest {

    @Autowired
    HelloService helloService;

    @Test
    public void testOne(){
        Assert.assertTrue(1==1);
    }

}
