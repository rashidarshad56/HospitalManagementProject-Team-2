package com.cg.hospital.serviceImplt;

import com.cg.hospital.entity.Patient;
import com.cg.hospital.entity.Stay;
import com.cg.hospital.repository.StayRepository;
import com.cg.hospital.serviceImpl.StayServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
 
import java.time.LocalDateTime;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
@ExtendWith(MockitoExtension.class)
class StayServiceImplTest {
 
    @Mock
    private StayRepository stayRepository;
 
    @InjectMocks
    private StayServiceImpl stayService;
 
    @Test
   void getStaysByPatientSsn_shouldReturnStaysForGivenSsn() {
        int ssn = 100000003;
 
        // Create mock Patient
        Patient patient = new Patient();
        patient.setSsn(ssn);
 
        // Create Stay 1
        Stay stay1 = new Stay();
        stay1.setStayId(3216);
        stay1.setPatient(patient);
        stay1.setRoom(123);
        stay1.setStayStart(LocalDateTime.of(2008, 5, 3, 0, 0));
        stay1.setStayEnd(LocalDateTime.of(2008, 5, 14, 0, 0));
 
        // Create Stay 2
        Stay stay2 = new Stay();
        stay2.setStayId(3215);
        stay2.setPatient(patient);
        stay2.setRoom(111);
        stay2.setStayStart(LocalDateTime.of(2008, 5, 1, 0, 0));
        stay2.setStayEnd(LocalDateTime.of(2008, 5, 4, 0, 0));
 
        // Mock repository response
        when(stayRepository.findByPatient_Ssn(ssn)).thenReturn(List.of(stay1, stay2));
 
        // Call service method
        List<Stay> result = stayService.getStaysByPatientSsn(ssn);
 
        // Assertions
        assertEquals(2, result.size());
 
        Stay result1 = result.get(0);
        assertEquals(3216, result1.getStayId());
        assertEquals(123, result1.getRoom());
        assertEquals(LocalDateTime.of(2008, 5, 3, 0, 0), result1.getStayStart());
        assertEquals(LocalDateTime.of(2008, 5, 14, 0, 0), result1.getStayEnd());
        assertEquals(ssn, result1.getPatient().getSsn());
 
        Stay result2 = result.get(1);
        assertEquals(3215, result2.getStayId());
        assertEquals(111, result2.getRoom());
        assertEquals(LocalDateTime.of(2008, 5, 1, 0, 0), result2.getStayStart());
        assertEquals(LocalDateTime.of(2008, 5, 4, 0, 0), result2.getStayEnd());
        assertEquals(ssn, result2.getPatient().getSsn());
 
        verify(stayRepository, times(1)).findByPatient_Ssn(ssn);
    }

}
