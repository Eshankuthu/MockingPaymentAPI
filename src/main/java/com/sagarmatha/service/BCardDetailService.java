package com.sagarmatha.service;



import com.sagarmatha.domain.CardDetail;

public interface BCardDetailService {
	
	CardDetail getFilteredCardDetail(String cardname);
}
