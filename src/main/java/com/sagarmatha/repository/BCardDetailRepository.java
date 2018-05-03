package com.sagarmatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.CardDetail;



@Repository
public interface BCardDetailRepository extends JpaRepository<CardDetail,Integer>{
	
	@Query("Select a from CardDetail a where a.cardHolderName = :cardname")
	public CardDetail getFilteredCardDetail(@Param("cardname") String cardname);
}
