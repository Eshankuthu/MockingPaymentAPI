package com.sagarmatha.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sagarmatha.model.TransactionRequest;
import com.sagarmatha.service.OrderService;
import com.sagarmatha.util.JsonConverter;

@Service
public class OrderServiceImpl implements OrderService{
	
	  final String uri = "http://localhost:8080/sagarmathamarketplace/bank/mock/transaction/api";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public String doTransaction(String txnId, String srcCardNo, String expirationDate, String nameOnCard, String CVV,
			String zipCode, Double amount, String dstCardNo,List<String> destinatioinscard) {
		
		TransactionRequest transactionRequest = new TransactionRequest(txnId, srcCardNo, expirationDate, nameOnCard, CVV, zipCode, amount, dstCardNo,destinatioinscard);
         
	/*	String sendData;
		try {
			sendData = JsonConverter.<TransactionRequest>objectToJson(transactionRequest);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}*/
		
		String resultReceive;
		
		resultReceive=restTemplate.postForObject(uri, transactionRequest,String.class);
	
		System.out.println(resultReceive);
		return resultReceive;
	}
	
	
}
