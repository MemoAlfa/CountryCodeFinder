package com.foodora.countryapp.service;

import com.foodora.countryapp.models.Country;
import com.foodora.repository.CountryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * class testing the service layer with mocking
 *
 * @author Mohamad Alaloush
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CountryServiceImpl.class)
public class CountyServiceImplTest {

//   setting up the context
    @TestConfiguration
    static class CountryServiceImplTestContext {

        @Bean
        public CountryServiceImpl countryService() {
            return new CountryServiceImpl();
        }
    }

    public static final Country germany = new Country("DE", "Germany");
    public static final Country random = new Country("RAN", "random");

    @Autowired
    private CountryService countryServiceImpl;

    @MockBean
    private CountryRepository countryRepository;
//  mocking setup
    @Before
    public void setUp() {
        List<Country> searchResult = new ArrayList<>();
        searchResult.add(germany);
        List<Country> getAllResult = new ArrayList<>();
        getAllResult.add(germany);
        getAllResult.add(random);

        Mockito.when(countryRepository.findCountriesByNameIsContainingIgnoreCase(germany.getName())).thenReturn(searchResult);
        Mockito.when(countryRepository.findCountriesByCodeIsContainingIgnoreCase(germany.getCode())).thenReturn(searchResult);
        Mockito.when(countryRepository.findAll()).thenReturn(getAllResult);
    }

    @Test
    public void whenValidCode_theCountryShouldBeFound() {
        List<Country> result = countryServiceImpl.getCountryByCode(germany.getCode());
        assertThat(result).contains(germany);
    }

    @Test
    public void whenValidName_thenCountryShouldBeFound() {
        List<Country> result = countryServiceImpl.getCountryByName(germany.getName());

        assertThat(result).contains(germany);
    }

    @Test
    public void whenGettingAll_AllShouldBeReturned() {
        List<Country> result = countryServiceImpl.getAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
