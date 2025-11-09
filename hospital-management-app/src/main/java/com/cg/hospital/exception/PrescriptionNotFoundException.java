package com.cg.hospital.exception;


@SuppressWarnings("serial")
public class PrescriptionNotFoundException extends RuntimeException {

    public PrescriptionNotFoundException(int patientId) {
        super("No prescriptions found for patient with ID: " + patientId);
    }

    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}