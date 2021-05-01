package com.company.service.gateway;

import com.company.dto.CountryDTO;
import com.company.mapper.CountryMapper;
import com.company.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryGateway {

    private final RestTemplate restTemplate;
    private final CountryMapper countryMapper;

    @Value("${countries.url}")
    private String url;

    @Autowired
    public CountryGateway(RestTemplate restTemplate, CountryMapper countryMapper) {
        this.restTemplate = restTemplate;
        this.countryMapper = countryMapper;
    }

    public List<Country> getAllCountriesFromRest() {

        //requestEntity
        // https://www.javatips.net/api/org.springframework.http.requestentity
        //IF NEED GET LIST of something (single just Class.class)
        ResponseEntity<List<CountryDTO>> result = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CountryDTO>>() {
                });
        List<CountryDTO> countiesDTO = result.getBody();
        List<Country> countries = countiesDTO.stream()
                .map(countryMapper::fromDTO)
                .collect(Collectors.toList());
        return countries;
    }

}
