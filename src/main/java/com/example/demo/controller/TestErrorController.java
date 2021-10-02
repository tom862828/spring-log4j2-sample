package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestController
@RequestMapping("/error")
public class TestErrorController implements ErrorController{
	private static final Logger Log = LoggerFactory.getLogger(TestErrorController.class);
	
	private static final String DEFAULT_ERROR_VIEW = "pages/404"; 
	@RequestMapping
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNotFoundError404(HttpServletRequest req,NoHandlerFoundException e){
			ModelAndView mav = new ModelAndView(); 
			mav.addObject("Exception", e);
			mav.addObject("Url", req.getRequestURL());
			mav.setViewName(DEFAULT_ERROR_VIEW); 
			Log.error("URL not found exception: " + e.getMessage());
			return mav;
	}
}
