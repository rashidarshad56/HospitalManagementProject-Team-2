package com.cg.hospital.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.hospital.entity.Patient;
import com.cg.hospital.entity.Stay;
import com.cg.hospital.repository.StayRepository;

public class StayServiceImplTest {

    @Mock
    private StayRepository stayRepository;

    @InjectMocks
    private StayServiceImpl stayService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStaysByPatientSsn() {
        int ssn = 100000003;

        // Create mock patient
        Patient patient = new Patient();
        patient.setSsn(ssn);
        patient.setName("Alice Johnson");

        // Create mock stays
        Stay stay1 = new Stay();
        stay1.setStayId(3216);
        stay1.setPatient(patient);
        stay1.setRoom(123);
        stay1.setStayStart(LocalDateTime.of(2008, 5, 3, 0, 0));
        stay1.setStayEnd(LocalDateTime.of(2008, 5, 14, 0, 0));

        Stay stay2 = new Stay();
        stay2.setStayId(3215);
        stay2.setPatient(patient);
        stay2.setRoom(111);
        stay2.setStayStart(LocalDateTime.of(2008, 5, 1, 0, 0));
        stay2.setStayEnd(LocalDateTime.of(2008, 5, 4, 0, 0));

        // Mock repository behavior
        when(stayRepository.findByPatient_Ssn(ssn)).thenReturn(Arrays.asList(stay1, stay2));

        // Call service method
        List<Stay> result = stayService.getStaysByPatientSsn(ssn);

        // Validate results
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