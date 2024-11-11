package com.example.drivepool.repository;

import com.example.drivepool.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Tambahkan metode kustom jika diperlukan
}
