package com.sagarmatha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagarmatha.service.BTransactionService;

@RestController
public class BTransactionRestController {
	
	@Autowired
	BTransactionService btransactionservice;
	
	
	
	@PostMapping(value="/bank/mock/transaction/api")
	public ResponseEntity<String> doTransaction(@RequestBody String requestString){
		System.out.println("******************************");
		 System.out.println("TR - " + requestString);
		 String receviceresponse = btransactionservice.doTransaction(requestString);
		return new ResponseEntity<String>(receviceresponse,HttpStatus.OK);
	}

}
