package com.cg.employeepayrollapp.exceptions;

public class DataMissingException extends RuntimeException{
	public DataMissingException(String message) {
		super(message);
	}

}