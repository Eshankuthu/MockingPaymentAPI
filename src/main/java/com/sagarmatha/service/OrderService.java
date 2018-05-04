package com.sagarmatha.service;

public interface OrderService {
	
	String doTransaction(String txnId, String srcCardNo, String expirationDate, String nameOnCard, String CVV, String zipCode, Double amount, String dstCardNo);

}
