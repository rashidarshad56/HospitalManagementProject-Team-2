package com.cg.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlockNotFoundException.class)
    public ResponseEntity<String> handleBlockNotFound(BlockNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AppointmentNotFoundException.class)
	    public ResponseEntity<String> handleAppointmentNotFound(AppointmentNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
     @ExceptionHandler(NurseNotFoundException.class)
    public ResponseEntity<String> handleNurseNotFound(NurseNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
     @ExceptionHandler(PrescriptionNotFoundException.class)
    public ResponseEntity<String> handleNoPrescriptionsFound(PrescriptionNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StayNotFoundException.class)
    public ResponseEntity<String> handleStayNotFoundException(StayNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
