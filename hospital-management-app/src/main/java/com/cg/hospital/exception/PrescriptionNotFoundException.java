package com.cg.hospital.exception;


public class PrescriptionNotFoundException extends RuntimeException {

    public PrescriptionNotFoundException(Long patientId) {
        super("No prescriptions found for patient with ID: " + patientId);
    }

    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}