package com.sagarmatha.service;

public interface OrderService {
	
	Integer doTransaction(String txnId, String srcCardNo, String expirationDate, String nameOnCard, String CVV, String zipCode, Double amount, String dstCardNo);

}
