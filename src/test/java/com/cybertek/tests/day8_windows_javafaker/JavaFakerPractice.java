package com.cybertek.tests.day8_windows_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void test1(){
        Faker faker = new Faker();

        String name = faker.name().firstName();
        System.out.println(name);

        String address = faker.address().fullAddress();
        System.out.println(address);
    }
}
