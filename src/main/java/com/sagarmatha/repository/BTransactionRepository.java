package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.BTransaction;

@Repository
public interface BTransactionRepository extends JpaRepository<BTransaction, Long>{

}
