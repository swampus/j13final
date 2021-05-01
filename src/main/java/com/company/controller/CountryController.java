package com.company.controller;

import com.company.dto.BookDTO;
import com.company.dto.CountryDTO;
import com.company.mapper.CountryMapper;
import com.company.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/Country.svc")
public class CountryController {

    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @Autowired
    public CountryController(CountryService countryService,
                             CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

    @GetMapping("/countries")
    public List<CountryDTO> findAllCountries() {
        return countryService.getAllCountries().stream()
                .map(countryMapper::toDTO)
                .collect(Collectors.toList());
    }

}
