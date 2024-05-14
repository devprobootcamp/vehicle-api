package com.devpro.vehicles.devprovehiclesservice.service;

import com.devpro.vehicles.devprovehiclesservice.dto.Vehicle;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleService {
    private static final Map<String, Vehicle> vehicleMap = new HashMap<>();

    public VehicleService() {

        vehicleMap.put("elantra", new Vehicle("Hyundai", "Elantra", List.of("2014", "2018")));
        vehicleMap.put("tundra", new Vehicle("Toyota", "Tundra", List.of("2018", "2019")));
        vehicleMap.put("atima", new Vehicle("Nissan", "Atima", List.of("2010", "2012")));
        vehicleMap.put("versan note", new Vehicle("Nissan", "Versan note", List.of("2010", "2012")));


    }

    public List<Vehicle> getAllVehicle() {
        return List.copyOf(vehicleMap.values());

    }

    public void deleteVehicle(String model) {
        vehicleMap.remove(model);
    }

    public Vehicle getVehicleModel(String model) {
        return vehicleMap.get(model.toLowerCase());
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getModel(), vehicle);
    }

    public Boolean updateVehicle(Vehicle vehicle, String model) {
        if (vehicleMap.containsKey(model)) {
            vehicleMap.put(model, vehicle);
            return true;
        }
        return false;
    }

    public List<Vehicle> searchVehicle(String year) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : vehicleMap.values()) {
            if (v.getYears().contains(year)) {
                vehicles.add(v);
            }
        }
        return vehicles;
    }
}
