package com.company.mapper;

import com.company.dto.CountryDTO;
import com.company.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public Country fromDTO(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());
        country.setCapitalCity(countryDTO.getCapitalCity());
        country.setPopulation(countryDTO.getPopulation());
        return country;
    }

    public CountryDTO toDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setCapitalCity(country.getCapitalCity());
        countryDTO.setPopulation(country.getPopulation());
        return countryDTO;
    }

}
