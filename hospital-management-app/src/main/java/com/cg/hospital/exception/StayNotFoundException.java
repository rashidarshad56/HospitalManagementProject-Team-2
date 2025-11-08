package com.cg.hospital.exception;
public class StayNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public StayNotFoundException(int ssn) {
		super("Patient with SSn " + ssn + " does not have any stays");
	}

}
