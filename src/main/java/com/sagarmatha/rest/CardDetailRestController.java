package com.sagarmatha.rest;


import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagarmatha.domain.CardDetail;
import com.sagarmatha.domain.User;
import com.sagarmatha.service.BCardDetailService;


@RestController
@RequestMapping("/api")
public class CardDetailRestController {
	
	  @Autowired
	  BCardDetailService bcardDetailService;
	 
	  @RequestMapping(value = "/getcard", method = RequestMethod.GET)
	  public ResponseEntity<JSONObject> checkCard(String cardname,String cardnumber,String cvv,String month,String year) {
	      System.out.println("inside getcard"); 
		  User user = new User();
	       user.setUserId(2);
	      CardDetail checkcard=bcardDetailService.getFilteredCardDetail(cardname);
//		  CardDetail checkcard = new CardDetail(5, user, "Eshan", "VISA", "123456789", "02", "2019", "333");
		  System.out.println(checkcard);
		  JSONObject obj = new JSONObject();
	      if(checkcard==null) {
	      
	      obj.put("a","Your card is not Valid");
		}else {
			obj.put("a","hello");
		}
	        return new ResponseEntity<JSONObject>(obj, HttpStatus.OK);
	    }
	 
}
