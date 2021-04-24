package com.company.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/rest")
public class MiscController {


    @Value("${current.environment}")
    private String currentEnvironment;

    private String startDate;

    //start when all ready
    @PostConstruct
    private void init() {
        SimpleDateFormat dt =
                new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        startDate = dt.format(new Date());
    }

    @GetMapping("/info")
    public String getInfo() {
        return "<table><tr><td width=\"35%\"><b>Server start date: </b><td><td>" + startDate + "</td>" +
                "<tr><td width=\"35%\"><b> Current Environment: </b></td><td>" + currentEnvironment
                + "</td></tr></table>";
    }
}
