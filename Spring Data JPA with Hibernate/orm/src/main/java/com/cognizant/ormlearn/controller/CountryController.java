package com.cognizant.ormlearn.controller;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> testGetAllCountries() {

        return countryService.getAllCountries();

    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {

        try {

            return countryService.findCountryByCode(code);

        } catch (Exception e) {

            return null;

        }

    }

    @PostMapping
    public void addCountry(@RequestBody Country country) {

        countryService.addCountry(country);

    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {

        countryService.deleteCountry(code);

    }

    @PutMapping
    public void updateCountry(@RequestBody Country country) {

        countryService.updateCountry(country.getCountryCode(), country.getCountryName());

    }

    @GetMapping("/search")
    public List<Country> findByNameContainingIgnoreCase(@RequestParam String name) {

        return countryService.findCountryByNameContaining(name);

    }

    @GetMapping("/search/sorted")
    public List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(@RequestParam String name) {

        return countryService.findCountryByNameContainingOrderByNameAsc(name);

    }

    @GetMapping("/search/start")
    public List<Country> findByNameStartingWithIgnoreCase(@RequestParam String name) {

        return countryService.findCountryByNameStartingWith(name);

    }

}
