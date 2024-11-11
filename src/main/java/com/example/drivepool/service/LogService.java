package com.example.drivepool.service;

import com.example.drivepool.model.Log;
import com.example.drivepool.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;  // Pastikan LogRepository di-autowire dengan benar

    // Mendapatkan semua log
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    // Mendapatkan log berdasarkan ID
    public Log getLogById(Long id) {
        Optional<Log> log = logRepository.findById(id);
        return log.orElse(null);  // Jika log tidak ditemukan, mengembalikan null
    }

    // Menyimpan log baru
    public Log saveLog(Log log) {
        return logRepository.save(log);
    }

    // Menghapus log berdasarkan ID
    public void deleteLog(Long id) {
        logRepository.deleteById(id);  // Menghapus log berdasarkan ID
    }
}
