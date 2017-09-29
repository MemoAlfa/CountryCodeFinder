package com.foodora.countryapp.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * tests the Application Context
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryCodeFinderApplicationTest {


    @Autowired
    private CountryCodeFinderApplication context;

//   testing that the context is loaded
    @Test
    public void contextLoads() {
        assertThat(context).isNotNull();
    }

}
