package com.sagarmatha.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BAccount")
public class BAccount {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cardNo;

    private String expirationDate;
    
    @Column(name = "name_on_card")
    private String name;

    private String CVV;

    private String zipCode;

    private Double amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public BAccount() {
    }

    public BAccount(String cardNo, String expirationDate, String name, String CVV, String zipCode) {
        this.cardNo = cardNo;
        this.expirationDate = expirationDate;
        this.name = name;
        this.CVV = CVV;
        this.zipCode = zipCode;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", cardNo=" + cardNo + ", expirationDate=" + expirationDate + ", name=" + name + ", CVV=" + CVV + ", zipCode=" + zipCode + ", amount=" + amount + ", createdAt=" + createdAt + '}';
    }


}
