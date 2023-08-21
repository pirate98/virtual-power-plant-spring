package com.example.virtualpowerplant.service;

import com.example.virtualpowerplant.model.Battery;
import com.example.virtualpowerplant.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    @Autowired
    public BatteryServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    @Override
    public Battery saveBattery(Battery battery) {
        return batteryRepository.save(battery);
    }

    @Override
    public List<String> getBatteriesInRange(String startPostcode, String endPostcode) {
        return batteryRepository.findAll().stream()
                .filter(battery -> battery.getPostcode().compareTo(startPostcode) >= 0
                        && battery.getPostcode().compareTo(endPostcode) <= 0)
                .sorted((b1, b2) -> b1.getName().compareTo(b2.getName()))
                .map(Battery::getName)
                .collect(Collectors.toList());
    }
}
