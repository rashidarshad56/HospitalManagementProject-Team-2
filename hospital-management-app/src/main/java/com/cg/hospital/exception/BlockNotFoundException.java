package com.cg.hospital.exception;

@SuppressWarnings("serial")
public class BlockNotFoundException extends RuntimeException {
    public BlockNotFoundException(String message) {
        super(message);
    }
}