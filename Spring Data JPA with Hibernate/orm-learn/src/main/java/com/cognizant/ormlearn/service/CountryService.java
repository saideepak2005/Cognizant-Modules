package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {

        return countryRepository.findAll();

    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }
        return result.get();

    }

    @Transactional
    public void addCountry(Country country) {

        countryRepository.save(country);

    }

    @Transactional
    public void updateCountry(String countryCode, String countryName) {

        Optional<Country> result = countryRepository.findById(countryCode);
        if (result.isPresent()) {
            Country country = result.get();
            country.setCountryName(countryName);
            countryRepository.save(country);
        }

    }

    @Transactional
    public void deleteCountry(String countryCode) {

        countryRepository.deleteById(countryCode);

    }

    @Transactional(readOnly = true)
    public List<Country> findCountryByNameContaining(String name) {

        return countryRepository.findByCountryNameContainingIgnoreCase(name);

    }

    @Transactional(readOnly = true)
    public List<Country> findCountryByNameContainingOrderByNameAsc(String name) {

        return countryRepository.findByCountryNameContainingIgnoreCaseOrderByCountryNameAsc(name);

    }

    @Transactional(readOnly = true)
    public List<Country> findCountryByNameStartingWith(String alphabet) {

        return countryRepository.findByCountryNameStartingWithIgnoreCase(alphabet);

    }

}
