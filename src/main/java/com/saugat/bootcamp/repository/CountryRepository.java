package com.saugat.bootcamp.repository;

import com.saugat.bootcamp.dto.Country;
import com.saugat.bootcamp.exceptions.ResourceNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CountryRepository {

    private Map<String, Country> countryMap = new HashMap<>();

    @PostConstruct
    public void init(){
        countryMap = Map.of(
                "NP", new Country("NP", "Nepal", "Nepal is a beautiful country."),
                "US", new Country("US", "United States", "The USA is known for innovation."),
                "IN", new Country("IN", "India", "India has rich cultural heritage."),
                "JP", new Country("JP", "Japan", "Japan is known for technology and tradition."),
                "AU", new Country("AU", "Australia", "Australia is famous for wildlife."),
                "CA", new Country("CA", "Canada", "Canada is known for nature."),
                "GB", new Country("GB", "United Kingdom", "The UK has historic landmarks."),
                "DE", new Country("DE", "Germany", "Germany is known for engineering."),
                "FR", new Country("FR", "France", "France is famous for art."),
                "CN", new Country("CN", "China", "China has ancient civilization.")
        );
    }

    public Country get(String code) {
        return countryMap.get(code);
    }

    public List<Country> getAll() {
        return new ArrayList<>(countryMap.values());
    }

    public Country create(Country country){
        countryMap.put(country.getCode(), country);
        return country;
    }

    public Country edit(String code, Country updatedCountry) {
        if (!countryMap.containsKey(code)) {
            throw new ResourceNotFoundException("Country not found with code: " + code);
        }
        updatedCountry.setCode(code);
        countryMap.put(code, updatedCountry);
        return updatedCountry;
    }

    public void delete(String code) {
        if (!countryMap.containsKey(code)) {
            throw new ResourceNotFoundException("Country not found with code: " + code);
        }
        countryMap.remove(code);
    }

}
