package com.sagarmatha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("checkout")
public class OrderController {
	
	
	@RequestMapping(value="/card", method = RequestMethod.GET)
	public String order() {
		return "order";
		
	}


}
