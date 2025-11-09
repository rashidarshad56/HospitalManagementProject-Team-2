package com.cg.hospital.serviceImplt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.hospital.dto.AppointmentPatientDTO;
import com.cg.hospital.entity.Appointment;
import com.cg.hospital.entity.Patient;
import com.cg.hospital.entity.Physician;
import com.cg.hospital.repository.AppointmentRepository;
import com.cg.hospital.serviceImpl.AppointmentServiceImpl;

public class AppointmentServiceImplTest {
	 @Mock
	    private AppointmentRepository appointmentRepository;

	    @InjectMocks
	    private AppointmentServiceImpl appointmentService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testGetPatientsByPhysicianEmployeeId() {
	        // Mock Physician
	        Physician physician = new Physician();
	        physician.setEmployeeId(1);
	        physician.setName("Dr. House");

	        // Mock Patients
	        Patient patient1 = new Patient();
	        patient1.setSsn(100000001);
	        patient1.setName("John Smith");
	        patient1.setAddress("42 Foobar Lane");
	        patient1.setPhone("555-0256");

	        Patient patient2 = new Patient();
	        patient2.setSsn(100000002);
	        patient2.setName("Grace Ritchie");
	        patient2.setAddress("37 Snafu Drive");
	        patient2.setPhone("555-0512");

	        // Mock Appointments
	        Appointment a1 = new Appointment();
	        a1.setAppointmentId(13216584);
	        a1.setPhysician(physician);
	        a1.setPatient(patient1);
	        a1.setStarto(LocalDateTime.of(2008, 4, 24, 10, 0));
	        a1.setEndo(LocalDateTime.of(2008, 4, 24, 11, 0));
	        a1.setExaminationRoom("Room A");

	        Appointment a2 = new Appointment();
	        a2.setAppointmentId(26548913);
	        a2.setPhysician(physician);
	        a2.setPatient(patient2);
	        a2.setStarto(LocalDateTime.of(2008, 4, 24, 10, 0));
	        a2.setEndo(LocalDateTime.of(2008, 4, 24, 11, 0));
	        a2.setExaminationRoom("Room B");

	        when(appointmentRepository.findByPhysician_EmployeeId(1)).thenReturn(List.of(a1, a2));

	        // Call service method
	        List<AppointmentPatientDTO> result = appointmentService.getPatientsByPhysicianEmployeeId(1);

	        // Validate size
	        assertEquals(2, result.size());

	        // Validate first DTO
	        AppointmentPatientDTO dto1 = result.get(0);
	        assertEquals("Dr. House", dto1.getPhysicianName());
	        assertEquals(13216584, dto1.getAppointmentId());
	        assertEquals("John Smith", dto1.getPatientName());
	        assertEquals("42 Foobar Lane", dto1.getAddress());
	        assertEquals("555-0256", dto1.getPhone());
	        assertEquals(LocalDateTime.of(2008, 4, 24, 10, 0), dto1.getStarto());
	        assertEquals(LocalDateTime.of(2008, 4, 24, 11, 0), dto1.getEndo());
	        assertEquals("Room A", dto1.getExaminationRoom());

	        // Validate second DTO
	        AppointmentPatientDTO dto2 = result.get(1);
	        assertEquals("Dr. House", dto2.getPhysicianName());
	        assertEquals(26548913, dto2.getAppointmentId());
	        assertEquals("Grace Ritchie", dto2.getPatientName());
	        assertEquals("Room B", dto2.getExaminationRoom());

	        verify(appointmentRepository, times(2)).findByPhysician_EmployeeId(1);
	    }
}

