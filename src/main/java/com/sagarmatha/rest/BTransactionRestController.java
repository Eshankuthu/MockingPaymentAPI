package com.sagarmatha.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BTransactionRestController {
	
	@PostMapping(value="/bank/mock/transaction/api")
	public ResponseEntity<Integer> doTransaction(@RequestBody String requestString){
		 System.out.println("TR - " + requestString);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

}
