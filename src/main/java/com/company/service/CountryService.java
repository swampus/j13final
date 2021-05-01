package com.company.service;

import com.company.model.Country;
import com.company.repository.CountryRepository;
import com.company.service.gateway.CountryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryGateway countryGateway;

    @Autowired
    public CountryService(CountryRepository countryRepository, CountryGateway countryGateway) {
        this.countryRepository = countryRepository;
        this.countryGateway = countryGateway;
    }

    //When spring ready app ready then are executed Post contrcut
    @PostConstruct
    protected void init() {
        countryRepository.saveAll(
                countryGateway.getAllCountriesFromRest());
    }

    public List<Country> saveAllCountries(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
