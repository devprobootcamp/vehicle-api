package com.devpro.vehicles.devprovehiclesservice.dto;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@Data

public class Vehicle {
    private String make;
    private String model;
    private List<String> years;


}
