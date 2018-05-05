package com.sagarmatha.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagarmatha.domain.BAccount;
import com.sagarmatha.model.TransactionRequest;
import com.sagarmatha.repository.BAccountRepository;
import com.sagarmatha.service.BTransactionService;

@Service
public class BTransactionServiceImpl implements BTransactionService {
    
	private final Logger logger = LogManager.getLogger(BTransactionServiceImpl.class);
	
    private final ObjectMapper mapper = new ObjectMapper(); 
    
    @Autowired
    BAccountRepository baccountrepository;
	@Override
	public String doTransaction(String requestString) {
		
		Integer errorCode=0;
		Double usedAmount = 0.0;
		Double availableAmount = 0.0;
		
		TransactionRequest openRequestString = new TransactionRequest();
		try {
			openRequestString = mapper.readValue(requestString,TransactionRequest.class);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}      

		BAccount requestaccount =  new BAccount(openRequestString.getSrcCardNo(), openRequestString.getExpirationDate(), openRequestString.getNameOnCard(), openRequestString.getCVV(), openRequestString.getZipCode());
		
		
		
		//Testing with Repository
		/*List<BAccount> getSameCardno = baccountrepository.findByCardNo(openRequestString.getSrcCardNo());
		getSameCardno.forEach(a->System.out.println(a));
		System.out.println(findSaveAccount);*/
		logger.info("Get the source account from the DB.");
		
		BAccount getSrcAccount = baccountrepository.getByCardNoAndNameAndCvvAndZipCode(openRequestString.getSrcCardNo(), openRequestString.getNameOnCard(), openRequestString.getZipCode(), openRequestString.getCVV());
		if(getSrcAccount==null) {
			errorCode=5;
		}else if(getSrcAccount.getAmount()<openRequestString.getAmount()){
			errorCode=6;	
		}else {
			errorCode=1;
		}
		
		if(errorCode==1) {
			availableAmount=getSrcAccount.getAmount()-openRequestString.getAmount();
			usedAmount+=openRequestString.getAmount();
		     
			getSrcAccount.setAmount(availableAmount);
			
			
		}
		
		return errorCode.toString();
	}

}
