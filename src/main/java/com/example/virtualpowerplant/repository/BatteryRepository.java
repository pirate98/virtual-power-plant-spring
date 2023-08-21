package com.example.virtualpowerplant.repository;

import com.example.virtualpowerplant.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, Long> {
}
