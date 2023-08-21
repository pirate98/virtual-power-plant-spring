package com.example.virtualpowerplant.controller;

import com.example.virtualpowerplant.model.Battery;
import com.example.virtualpowerplant.service.BatteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BatteryControllerTest {

    private BatteryController batteryController;

    @Mock
    private BatteryService batteryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        batteryController = new BatteryController(batteryService);
    }

    @Test
    public void testCreateBattery() {
        Battery battery = new Battery("Battery1", "10001", 1000);
        when(batteryService.saveBattery(any())).thenReturn(battery);

        ResponseEntity<Battery> responseEntity = batteryController.createBattery(battery);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Battery1", responseEntity.getBody().getName());
    }

    @Test
    public void testGetBatteriesInRange() {
        List<String> batteryNames = new ArrayList<>();
        batteryNames.add("Battery1");
        batteryNames.add("Battery2");
        when(batteryService.getBatteriesInRange("10000", "30000")).thenReturn(batteryNames);

        ResponseEntity<List<String>> responseEntity = batteryController.getBatteriesInRange("10000", "30000");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
        assertEquals("Battery1", responseEntity.getBody().get(0));
        assertEquals("Battery2", responseEntity.getBody().get(1));
    }
}
