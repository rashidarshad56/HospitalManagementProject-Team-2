package com.cg.hospital.service;

import com.cg.hospital.entity.Stay;
import java.util.List;

public interface StayService {
   // List<Stay> getAllStays();  
    List<Stay> getStaysByPatientSsn(int ssn);
}