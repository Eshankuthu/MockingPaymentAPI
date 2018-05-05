package com.sagarmatha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagarmatha.model.SubmitForm;
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
	    public String getcheckoutCustomerOrder(@ModelAttribute("paymentForm") SubmitForm paymentForm) {
			return "submitorder";
	    	
	    }

    @PostMapping("checkout/submit")
    public String checkoutCustomerOrder(Model model,@ModelAttribute("paymentForm") SubmitForm paymentForm,@RequestParam("month") String month, @RequestParam("year") String year) {
    	paymentForm.setCardNumber(paymentForm.getCardNumber().replaceAll("\\s",""));
        paymentForm.setCardExpirationDate(month + "/" + year);
        String responseCode = orderservice.doTransaction("111", paymentForm.getCardNumber(),
            paymentForm.getCardExpirationDate(), paymentForm.getCardHolderName(), paymentForm.getCvv(),
            paymentForm.getCardZipcode(), (double) 3000, "4322637205582291");
        
        if(responseCode.equals("5")){
        	model.addAttribute("error", "Please Enter the Correct Card Detail");
        	return "submitorder";
        }
        if(responseCode.equals("6")) {
        	model.addAttribute("error", "Transaction Amount Not Sufficient");
        	return "submitorder";
        }
		return "ordersuccess";
    	
    }
}
