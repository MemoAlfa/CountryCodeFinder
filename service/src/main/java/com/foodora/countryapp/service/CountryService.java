package com.foodora.countryapp.service;

import com.foodora.countryapp.models.Country;

import java.util.List;

public interface CountryService {

    Country saveCountry(Country country);
    List<Country> getCountryByName(String name);
    List<Country> getCountryByCode(String code);
    List<Country> getAll();

}
