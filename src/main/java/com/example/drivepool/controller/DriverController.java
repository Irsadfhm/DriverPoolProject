package com.example.drivepool.controller;

import com.example.drivepool.model.Driver;
import com.example.drivepool.model.Log;
import com.example.drivepool.service.DriverService;
import com.example.drivepool.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private LogService logService;

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        // Simulasi pencatatan log
        Log log = new Log(driver.getCarID(), "PIK2", LocalDateTime.now());  // Perbaikan: gunakan LocalDateTime, bukan String
        logService.saveLog(log);
        
        return driverService.saveDriver(driver);
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        // Simulasi pencatatan log
        Log log = new Log(driver.getCarID(), "PIK2", LocalDateTime.now());  // Perbaikan: gunakan LocalDateTime, bukan String
        log.setUpdateAt(LocalDateTime.now());  // Perbaikan: gunakan LocalDateTime, bukan String
        logService.saveLog(log);

        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id) {
        Driver driver = driverService.getDriverById(id); // Ambil driver berdasarkan ID untuk log
        Log log = new Log(driver.getCarID(), "PIK2", LocalDateTime.now());  // Perbaikan: gunakan LocalDateTime, bukan String
        log.setUpdateAt(LocalDateTime.now());  // Perbaikan: gunakan LocalDateTime, bukan String
        logService.saveLog(log);

        driverService.deleteDriver(id);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }
}
