package com.example.virtualpowerplant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String postcode;
    private double wattCapacity;

    // Constructors
    public Battery() {
    }
    
    public Battery(String name, String postcode, double wattCapacity) {
        this.name = name;
        this.postcode = postcode;
        this.wattCapacity = wattCapacity;
    }

    // Getters and Setters
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public double getWattCapacity() {
        return wattCapacity;
    }

    public void setWattCapacity(double wattCapacity) {
        this.wattCapacity = wattCapacity;
    }
}
