package com.cg.hospital.exception;

public class NurseNotFoundException extends RuntimeException {
    public NurseNotFoundException(String message) {
        super(message);
    }
}