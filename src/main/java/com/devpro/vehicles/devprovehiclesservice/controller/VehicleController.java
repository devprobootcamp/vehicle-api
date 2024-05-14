package com.devpro.vehicles.devprovehiclesservice.controller;

import com.devpro.vehicles.devprovehiclesservice.dto.Vehicle;
import com.devpro.vehicles.devprovehiclesservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.OK);

    }

    @DeleteMapping("/vehicles/{model}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String model) {
        vehicleService.deleteVehicle(model);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/vehicles/{model}")
    public ResponseEntity<Vehicle> getVehicleModel(@PathVariable String model) {

        return new ResponseEntity<>(vehicleService.getVehicleModel(model.toLowerCase()), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Void> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/vehicles/{model}")
    public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String model) {
        Boolean updatevehicle = vehicleService.updateVehicle(vehicle, model);
        if (updatevehicle) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/vehicles/search")
    public ResponseEntity<List<Vehicle>> searchVehicle(@RequestParam String year) {
       return new ResponseEntity<>(vehicleService.searchVehicle(year), HttpStatus.OK);
    }
}

