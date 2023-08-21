package com.example.virtualpowerplant.service;

import com.example.virtualpowerplant.model.Battery;

import java.util.List;

public interface BatteryService {
    Battery saveBattery(Battery battery);
    List<String> getBatteriesInRange(String startPostcode, String endPostcode);
}
