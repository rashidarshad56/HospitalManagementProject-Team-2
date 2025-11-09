package com.cg.hospital.serviceImplt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.cg.hospital.dto.AppointmentSummaryDTO;
import com.cg.hospital.entity.Appointment;
import com.cg.hospital.entity.Patient;
import com.cg.hospital.repository.PatientRepository;
import com.cg.hospital.serviceImpl.PatientServiceImpl;
 
public class PatientServiceImplTest {
 
	    @Mock
	    private PatientRepository patientRepository;
 
	    @InjectMocks
	    private PatientServiceImpl patientService;
 
	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
 
	    @Test
	    void testGetAllPatients() {
	        Patient p1 = new Patient();
	        p1.setSsn(100000001);
	        p1.setName("John Smith");
	        p1.setAddress("42 Foobar Lane");
 
	        Patient p2 = new Patient();
	        p2.setSsn(100000002);
	        p2.setName("Grace Ritchie");
	        p2.setAddress("37 Snafu Drive");
 
	        when(patientRepository.findAll()).thenReturn(Arrays.asList(p1, p2));
 
	        List<Patient> result = patientService.getAllPatients();
 
	        assertEquals(2, result.size());
	        assertEquals(100000001, result.get(0).getSsn());
	        assertEquals("John Smith", result.get(0).getName());
	        assertEquals("Grace Ritchie", result.get(1).getName());
	        verify(patientRepository, times(1)).findAll();
	    }
 
	    @Test
	    void testGetAppointmentsByPatientId() {
	        // Create mock patient based on DB SSN
	        Patient patient = new Patient();
	        patient.setSsn(100000001);
	        patient.setName("John Smith");
 
	        // Create mock appointment
	        Appointment appointment = new Appointment();
	        appointment.setAppointmentId(13216584);
	        appointment.setStarto(LocalDateTime.of(2008, 4, 24, 10, 0));
	        appointment.setEndo(LocalDateTime.of(2008, 4, 24, 11, 0));
	        appointment.setExaminationRoom("Room A");
 
	        // Assign appointment to patient
	        patient.setAppointments(List.of(appointment));
 
	        // Mock repository behavior
	        when(patientRepository.findById(100000001)).thenReturn(Optional.of(patient));
 
	        // Call service method
	        List<AppointmentSummaryDTO> result = patientService.getAppointmentsByPatientId(100000001);
 
	        // Validate result
	        assertEquals(1, result.size());
	        AppointmentSummaryDTO dto = result.get(0);
	        assertEquals(13216584, dto.getAppointmentId());
	        assertEquals(100000001, dto.getPatientId());
	        assertEquals(LocalDateTime.of(2008, 4, 24, 10, 0), dto.getStarto());
	        assertEquals(LocalDateTime.of(2008, 4, 24, 11, 0), dto.getEndo());
	        assertEquals("Room A", dto.getExaminationRoom());
 
	        verify(patientRepository, times(1)).findById(100000001);
	    }
}