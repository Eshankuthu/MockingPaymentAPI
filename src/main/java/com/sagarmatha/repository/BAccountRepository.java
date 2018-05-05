package com.sagarmatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.BAccount;

@Repository
public interface BAccountRepository extends JpaRepository<BAccount, Long> {
	
	Long countByCardNo(String cardNo);
	
	List<BAccount> findByCardNo(String cardNo);
	
	
	/*@Query("SELECT a FROM BAccount a WHERE "
            + "a.cardNo = ?1 and "
            + "a.name = ?2 and "
            + "a.zipCode = ?3 and "
            + "a.cvv = ?4")
    BAccount getByCardNoAndNameAndCvvAndZipCode(String cardNo, String name, String zipCode, String cvv);*/
	
	
	@Query("SELECT a FROM BAccount a WHERE a.cardNo = :cardNo AND a.name=:name AND a.zipCode=:zipCode AND a.cvv=:cvv")
	BAccount getByCardNoAndNameAndCvvAndZipCode(@Param("cardNo") String cardNo,@Param("name") String name,@Param("zipCode") String zipCode,@Param("cvv") String ccv);
		

}
