package com.foodora.countryapp.service;

import com.foodora.countryapp.models.Country;
import com.foodora.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country) {
        Country savedCountry = countryRepository.save(country);
        return savedCountry;
    }

    public List<Country> getCountryByName(String name) {
        return countryRepository.findCountriesByNameIsContainingIgnoreCase(name);
    }

    public List<Country> getCountryByCode(String code) {
        return countryRepository.findCountriesByCodeIsContainingIgnoreCase(code);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}

