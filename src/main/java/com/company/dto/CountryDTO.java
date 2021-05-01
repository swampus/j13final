package com.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDTO {
    private Long id;
    private String name;
    @JsonProperty("capital")
    private String capitalCity; //capital
    private Long population;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", population=" + population +
                '}';
    }
}
