package com.sagarmatha.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	private String cardNumber;
	
	private double transactionAmount;
	
	private double availableAmount;
	
	private double usedAmount;
	
	private int key;
	
	private boolean payCard;
	
	

	public Transaction(String cardNumber, double transactionAmount, double availableAmount,
			double usedAmount, int key, boolean payCard) {
		super();
		this.cardNumber = cardNumber;
		this.transactionAmount = transactionAmount;
		this.availableAmount = availableAmount;
		this.usedAmount = usedAmount;
		this.key = key;
		this.payCard = payCard;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}

	public double getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(double usedAmount) {
		this.usedAmount = usedAmount;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isPayCard() {
		return payCard;
	}

	public void setPayCard(boolean payCard) {
		this.payCard = payCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	

}
