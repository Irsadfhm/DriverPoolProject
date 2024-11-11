package com.example.drivepool.repository;

import com.example.drivepool.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Tambahkan metode kustom jika diperlukan
}
