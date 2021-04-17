package com.company.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ErrorDTO {

    private String message;
    private String path;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    public ErrorDTO() {
    }

    public ErrorDTO(String message, String path, Date date) {
        this.message = message;
        this.path = path;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
