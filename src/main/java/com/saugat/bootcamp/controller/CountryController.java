package com.saugat.bootcamp.controller;

import com.saugat.bootcamp.dto.Country;
import com.saugat.bootcamp.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Hello from CountryCountroller";
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> get(@PathVariable String code){
        Country country = service.get(code);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(country);
    }

    @GetMapping
    public ResponseEntity<List<Country>> get(){
        List<Country> countryList = service.get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countryList);
    }

    @PostMapping()
    public ResponseEntity<Country> create(@RequestBody Country obj){
        Country country = service.create(obj);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(country);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Country> edit(@PathVariable String code, @RequestBody Country obj){
        Country country = service.edit(code, obj);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(country);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code){
        service.delete(code);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(null);
    }
}
