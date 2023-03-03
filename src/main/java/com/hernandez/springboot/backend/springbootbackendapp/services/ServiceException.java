package com.hernandez.springboot.backend.springbootbackendapp.services;

import org.springframework.dao.DataAccessException;

public class ServiceException extends DataAccessException {

    public ServiceException(String msg) {
        super(msg);
    }
}
