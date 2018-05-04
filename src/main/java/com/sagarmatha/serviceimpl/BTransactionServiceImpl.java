package com.sagarmatha.serviceimpl;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagarmatha.domain.BAccount;
import com.sagarmatha.model.TransactionRequest;
import com.sagarmatha.service.BTransactionService;

@Service
public class BTransactionServiceImpl implements BTransactionService {
    
	private final Logger logger = LogManager.getLogger(BTransactionServiceImpl.class);
	
    private final ObjectMapper mapper = new ObjectMapper(); 
	@Override
	public String doTransaction(String requestString) {
		// TODO Auto-generated method stub
		
		TransactionRequest openRequestString = new TransactionRequest();
		try {
			openRequestString = mapper.readValue(requestString,TransactionRequest.class);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}      
		logger.info("Get the source account from the DB.");
		System.out.println(openRequestString);
		BAccount account =  new BAccount(openRequestString.getSrcCardNo(), openRequestString.getExpirationDate(), openRequestString.getNameOnCard(), openRequestString.getCVV(), openRequestString.getZipCode());
		return "a";
	}

}
