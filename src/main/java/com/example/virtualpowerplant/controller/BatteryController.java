package com.example.virtualpowerplant.controller;

import com.example.virtualpowerplant.model.Battery;
import com.example.virtualpowerplant.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {

    private final BatteryService batteryService;

    @Autowired
    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping
    public ResponseEntity<Battery> createBattery(@RequestBody Battery battery) {
        Battery savedBattery = batteryService.saveBattery(battery);
        return ResponseEntity.ok(savedBattery);
    }

    @GetMapping("/range")
    public ResponseEntity<List<String>> getBatteriesInRange(
            @RequestParam String startPostcode, @RequestParam String endPostcode) {
        List<String> batteriesInRange = batteryService.getBatteriesInRange(startPostcode, endPostcode);
        return ResponseEntity.ok(batteriesInRange);
    }
}
