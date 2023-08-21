package com.example.virtualpowerplant.service;

import com.example.virtualpowerplant.model.Battery;
import com.example.virtualpowerplant.repository.BatteryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BatteryServiceImplTest {

    private BatteryServiceImpl batteryService;

    @Mock
    private BatteryRepository batteryRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        batteryService = new BatteryServiceImpl(batteryRepository);
    }

    @Test
    public void testGetBatteriesInRange() {
        List<Battery> batteryList = new ArrayList<>();
        batteryList.add(new Battery("Battery1", "10001", 1000));
        batteryList.add(new Battery("Battery2", "20002", 1500));
        when(batteryRepository.findAll()).thenReturn(batteryList);

        List<String> result = batteryService.getBatteriesInRange("10000", "30000");

        assertEquals(2, result.size());
        assertEquals("Battery1", result.get(0));
        assertEquals("Battery2", result.get(1));
    }
}
