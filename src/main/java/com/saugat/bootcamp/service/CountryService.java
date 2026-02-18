package com.saugat.bootcamp.service;

import com.saugat.bootcamp.dto.Country;
import com.saugat.bootcamp.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements IService<Country, String>{

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country get(String id) {
        return repository.get(id);
    }


    @Override
    public List<Country> get() {
        return repository.getAll();
    }

    @Override
    public Country create(Country obj) {
        return repository.create(obj);
    }

    @Override
    public Country edit(String id, Country obj) {
        return repository.edit(id, obj);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
