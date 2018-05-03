package com.sagarmatha.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagarmatha.domain.CardDetail;
import com.sagarmatha.repository.BCardDetailRepository;
import com.sagarmatha.service.BCardDetailService;

@Service
public class BCardDetailServiceImpl implements BCardDetailService{

	@Autowired
	BCardDetailRepository bcardDetailRepository;
	
	@Override
	public CardDetail getFilteredCardDetail(String cardname) {
		
		return bcardDetailRepository.getFilteredCardDetail(cardname);
	}

}
