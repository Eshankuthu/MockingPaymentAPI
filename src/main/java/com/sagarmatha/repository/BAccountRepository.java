package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.BAccount;

@Repository
public interface BAccountRepository extends JpaRepository<BAccount, Long> {
	
	
}
