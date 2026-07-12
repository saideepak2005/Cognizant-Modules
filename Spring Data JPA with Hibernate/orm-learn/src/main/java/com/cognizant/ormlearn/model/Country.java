package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String countryCode;

    @Column(name = "co_name")
    private String countryName;

    public Country() {

    }

    public Country(String countryCode, String countryName) {

        this.countryCode = countryCode;
        this.countryName = countryName;

    }

    public String getCountryCode() {

        return countryCode;

    }

    public void setCountryCode(String countryCode) {

        this.countryCode = countryCode;

    }

    public String getCountryName() {

        return countryName;

    }

    public void setCountryName(String countryName) {

        this.countryName = countryName;

    }

    @Override
    public String toString() {

        return "Country{" +
                "code='" + countryCode + '\'' +
                ", name='" + countryName + '\'' +
                '}';

    }

}
