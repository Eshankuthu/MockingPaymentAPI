package com.sagarmatha.serviceimpl;

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
	public Integer doTransaction(String txnId, String srcCardNo, String expirationDate, String nameOnCard, String CVV,
			String zipCode, Double amount, String dstCardNo) {
		TransactionRequest transactionRequest = new TransactionRequest(txnId, srcCardNo, expirationDate, nameOnCard, CVV, zipCode, amount, dstCardNo);
         
		String sendData;
		try {
			sendData = JsonConverter.<TransactionRequest>objectToJson(transactionRequest);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		
		Integer resultReceive;
		
		resultReceive=restTemplate.postForObject(uri, transactionRequest,Integer.class);
	
		System.out.println(resultReceive);
		return resultReceive;
	}

}