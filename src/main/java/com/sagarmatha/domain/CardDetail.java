package com.sagarmatha.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CardDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cardId;
	
	@ManyToOne
	private User userId;
	
	private String cardHolderName;
	
	private String cardType;
	
	private String cardNumber;
	
	private String expireMonth;
	
	private String expireYear;
	
	private String CVV;
	
	
	

	public CardDetail(int cardId, User userId, String cardHolderName, String cardType, String cardNumber,
			String expireMonth, String expireYear, String cVV) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.cardHolderName = cardHolderName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
		CVV = cVV;
		
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}

	public String getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}	

}
