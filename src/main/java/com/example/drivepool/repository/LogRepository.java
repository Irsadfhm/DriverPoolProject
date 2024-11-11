package com.example.drivepool.repository;

import com.example.drivepool.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
    // JpaRepository sudah menyediakan banyak metode untuk interaksi dengan database
}
