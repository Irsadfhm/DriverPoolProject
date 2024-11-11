package com.example.drivepool.controller;

import com.example.drivepool.model.Log;
import com.example.drivepool.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/logs")  // Path untuk endpoint log
public class LogController {

    @Autowired
    private LogService logService;  // Pastikan LogService di-autowire dengan benar

    // Mengambil semua log
    @GetMapping
    public List<Log> getAllLogs() {
        return logService.getAllLogs();  // Mengambil semua log dari service
    }

    // Mengambil log berdasarkan ID
    @GetMapping("/{id}")
    public Log getLogById(@PathVariable Long id) {
        return logService.getLogById(id);  // Mengambil log berdasarkan ID
    }

    // Menyimpan log baru
    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.saveLog(log);  // Menyimpan log baru
    }

    // Memperbarui log berdasarkan ID
    @PutMapping("/{id}")
    public Log updateLog(@PathVariable Long id, @RequestBody Log logDetails) {
        Log existingLog = logService.getLogById(id);
        if (existingLog != null) {
            existingLog.setLocation(logDetails.getLocation());
            existingLog.setUpdateAt(LocalDateTime.now());
            return logService.saveLog(existingLog);
        }
        return null;  // atau lemparkan Exception jika log tidak ditemukan
    }

    // Menghapus log berdasarkan ID
    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);  // Memanggil service untuk menghapus log berdasarkan ID
    }
}
