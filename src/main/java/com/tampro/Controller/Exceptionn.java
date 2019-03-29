package com.tampro.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class Exceptionn {

	
	@ExceptionHandler(value= {NoHandlerFoundException.class})
	public String Exception(Exception exception)
	{
		System.out.println(exception);
		return "err";
	}
}
