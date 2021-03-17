package com.david.application.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidGenerator {

    public String generateUuid(){
        return UUID.randomUUID().toString(); //Add a random uuid to the product that just created
    }
}
