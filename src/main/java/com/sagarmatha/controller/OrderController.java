package com.sagarmatha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagarmatha.model.PaymentForm;
import com.sagarmatha.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	@RequestMapping(value="/card", method = RequestMethod.GET)
	public String order() {
		return "order";
		
	}
	
	   @GetMapping("checkout/submit")
	    public String getcheckoutCustomerOrder(@ModelAttribute("paymentForm") PaymentForm paymentForm) {
			return "submitorder";
	    	
	    }

    @PostMapping("checkout/submit")
    public String checkoutCustomerOrder(@ModelAttribute("paymentForm") PaymentForm paymentForm,@RequestParam("month") String month, @RequestParam("year") String year) {
    	paymentForm.setCardNumber(paymentForm.getCardNumber().replaceAll("\\s",""));
        paymentForm.setCardExpirationDate(month + "/" + year);
        Integer responseCode = orderservice.doTransaction("111", paymentForm.getCardNumber(),
            paymentForm.getCardExpirationDate(), paymentForm.getCardHolderName(), paymentForm.getCvv(),
            paymentForm.getCardZipcode(), (double) 5000, "4322637205582291");
        if(responseCode!=1) {
        	return "submitorder";
        }
		return "ordersuccess";
    	
    }
}
