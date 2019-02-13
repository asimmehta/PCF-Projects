package com.asim.config;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public String id;

    public String message;

    public Customer() {}

    public Customer(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, message='%s']", id, message);
    }

}