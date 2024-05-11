package com.devpro.vehicles.devprovehiclesservice.controller;

import com.devpro.vehicles.devprovehiclesservice.dto.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class VehicleController {
    private static final Map<String, Vehicle> vehicleMap = new HashMap<>();

    public VehicleController() {

        vehicleMap.put("elantra", new Vehicle("Hyundai", "Elantra", List.of("2014", "2018")));
        vehicleMap.put("tundra", new Vehicle("Toyota", "Tundra", List.of("2018", "2019")));
        vehicleMap.put("atima", new Vehicle("Nissan", "Atima", List.of("2010", "2012")));
        vehicleMap.put("versan note", new Vehicle("Nissan", "Versan note", List.of("2010", "2012")));


    }

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return List.copyOf(vehicleMap.values());

    }

    @DeleteMapping("/vehicles/{model}")
    public void deleteVehicle(@PathVariable String model) {
        vehicleMap.remove(model);
    }

    @GetMapping("/vehicles/{model}")
    public Vehicle getVehicleModel(@PathVariable String model) {

        return vehicleMap.get(model.toLowerCase());
    }

    @PostMapping("/vehicles")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleMap.put(vehicle.getModel(), vehicle);
    }

    @PutMapping("/vehicles/{model}")
    public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String model) {
        if (vehicleMap.containsKey(model)) {
            vehicleMap.put(model, vehicle);
            return ResponseEntity.ok("Success");
        } else {
            return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/vehicles/search")
    public List<Vehicle> searchVehicle(@RequestParam String year) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : vehicleMap.values()) {
            if (v.getYears().contains(year)) {
                vehicles.add(v);
            }
        }
        return vehicles;
    }
}

