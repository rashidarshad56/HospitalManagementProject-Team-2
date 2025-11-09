//
//
//
//
//
//package com.cg.hospital.serviceImpl;
//
//import com.cg.hospital.dto.PrescriptionDTO;
//import com.cg.hospital.entity.*;
//import com.cg.hospital.repository.PrescribesRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class PrescribeServiceImplTest {
//
//    @Mock
//    private PrescribesRepository prescribesRepo;
//
//    @InjectMocks
//    private PrescribeServiceImpl prescribeService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    // TC1: Valid patient with one prescription
//    @Test
//    void testGetPrescriptionsByPatientId_WithOnePrescription() {
//        Long patientId = 100000001L;
//
//        Patient patient = new Patient();
//        patient.setSsn(patientId);
//        patient.setName("John Smith");
//
//        Physician physician = new Physician();
////        physician.setEmployeeId(1);
//        physician.setName("John Dorian");
//        physician.setPosition("Staff Internist");
//
//        Medication medication = new Medication();
////        medication.setCode(101);
//        medication.setName("Procrastin-X");
//
//        Prescribes prescribes = new Prescribes();
//        prescribes.setPatient(patientId);
//        prescribes.setPatientDetails(patient);
//        prescribes.setPhysicianDetails(physician);
//        prescribes.setMedicationDetails(medication);
//        prescribes.setDose("5");
////        prescribes.setDate(LocalDateTime.of(2008, 4, 24, 10, 47));
//
//        when(prescribesRepo.findByPatient(patientId)).thenReturn(List.of(prescribes));
//
//        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);
//
//        assertEquals(1, result.size());
//        PrescriptionDTO dto = result.get(0);
//        assertEquals(patientId, dto.getPatientId());
//        assertEquals("John Smith", dto.getPatientName());
//        assertEquals("John Dorian", dto.getPhysicianName());
//        assertEquals("Staff Internist", dto.getPhysicianPosition());
//        assertEquals("Procrastin-X", dto.getMedicationName());
//        assertEquals("5", dto.getDose());
////        assertEquals(LocalDateTime.of(2008, 4, 24, 10, 47), dto.getDate());
//    }
//
//    // TC2: Valid patient with no prescriptions (100000002)
//    @Test
//    void testGetPrescriptionsByPatientId_WithNoPrescriptions_100000002() {
//        Long patientId = 100000002L;
//
//        when(prescribesRepo.findByPatient(patientId)).thenReturn(Collections.emptyList());
//
//        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);
//
//        assertTrue(result.isEmpty());
//    }
//
//    // TC3: Valid patient with no prescriptions (100000003)
//    @Test
//    void testGetPrescriptionsByPatientId_WithNoPrescriptions_100000003() {
//        Long patientId = 100000003L;
//
//        when(prescribesRepo.findByPatient(patientId)).thenReturn(Collections.emptyList());
//
//        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);
//
//        assertTrue(result.isEmpty());
//    }
//
//    // TC4: Valid patient with multiple prescriptions
//    @Test
//    void testGetPrescriptionsByPatientId_WithMultiplePrescriptions() {
//        Long patientId = 100000004L;
//
//        Patient patient = new Patient();
//        patient.setSsn(patientId);
//        patient.setName("Dennis Doe");
//
//        Physician physician = new Physician();
////        physician.setEmployeeId(9);
//        physician.setName("Molly Clock");
//        physician.setPosition("Attending Psychiatrist");
//
//        Medication medication = new Medication();
////        medication.setCode(2);
//        medication.setName("Thesisin");
//
//        Prescribes p1 = new Prescribes();
//        p1.setPatient(patientId);
//        p1.setPatientDetails(patient);
//        p1.setPhysicianDetails(physician);
//        p1.setMedicationDetails(medication);
//        p1.setDose("10");
////        p1.setDate(LocalDateTime.of(2008, 4, 27, 10, 53));
//
//        Prescribes p2 = new Prescribes();
//        p2.setPatient(patientId);
//        p2.setPatientDetails(patient);
//        p2.setPhysicianDetails(physician);
//        p2.setMedicationDetails(medication);
//        p2.setDose("5");
////        p2.setDate(LocalDateTime.of(2008, 4, 30, 16, 53));
//
//        when(prescribesRepo.findByPatient(patientId)).thenReturn(Arrays.asList(p1, p2));
//
//        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);
//
//        assertEquals(2, result.size());
//
//        PrescriptionDTO dto1 = result.get(0);
//        assertEquals("Dennis Doe", dto1.getPatientName());
//        assertEquals("Molly Clock", dto1.getPhysicianName());
//        assertEquals("Attending Psychiatrist", dto1.getPhysicianPosition());
//        assertEquals("Thesisin", dto1.getMedicationName());
//        assertEquals("10", dto1.getDose());
//
//        PrescriptionDTO dto2 = result.get(1);
//        assertEquals("Dennis Doe", dto2.getPatientName());
//        assertEquals("Molly Clock", dto2.getPhysicianName());
//        assertEquals("Attending Psychiatrist", dto2.getPhysicianPosition());
//        assertEquals("Thesisin", dto2.getMedicationName());
//        assertEquals("5", dto2.getDose());
//    }
//
//    // TC5: Invalid patient ID (not in DB)
//    @Test
//    void testGetPrescriptionsByPatientId_InvalidPatientId() {
//        Long patientId = 100000006L;
//
//        when(prescribesRepo.findByPatient(patientId)).thenReturn(Collections.emptyList());
//
//        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);
//
//        assertTrue(result.isEmpty());
//    }
//}



//
//package com.cg.hospital.service.impl;
//
//import com.cg.hospital.dto.PrescriptionDTO;
//import com.cg.hospital.entity.*;
//import com.cg.hospital.exception.PrescriptionNotFoundException;
//import com.cg.hospital.repository.PrescribesRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class PrescribeServiceImplTest {
//
//    @Mock
//    private PrescribesRepository prescribesRepo;
//
//    @InjectMocks
//    private PrescribeServiceImpl prescribeService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetPrescriptionsByPatientId_ValidAndInvalidCases() {
//        // Valid patient with one prescription
//        Long patientId1 = 100000001L;
//        Patient patient1 = new Patient();
//        patient1.setSsn(patientId1);
//        patient1.setName("John Smith");
//
//        Physician physician1 = new Physician();
//        physician1.setName("John Dorian");
//        physician1.setPosition("Staff Internist");
//
//        Medication medication1 = new Medication();
//        medication1.setName("Procrastin-X");
//
//        Prescribes prescribes1 = new Prescribes();
//        prescribes1.setPatient(patientId1);
//        prescribes1.setPatientDetails(patient1);
//        prescribes1.setPhysicianDetails(physician1);
//        prescribes1.setMedicationDetails(medication1);
//        prescribes1.setDose("5");
//
//        when(prescribesRepo.findByPatient(patientId1)).thenReturn(List.of(prescribes1));
//
//        List<PrescriptionDTO> result1 = prescribeService.getPrescriptionsByPatientId(patientId1);
//        assertEquals(1, result1.size());
//        PrescriptionDTO dto1 = result1.get(0);
//        assertEquals("John Smith", dto1.getPatientName());
//        assertEquals("John Dorian", dto1.getPhysicianName());
//        assertEquals("Staff Internist", dto1.getPhysicianPosition());
//        assertEquals("Procrastin-X", dto1.getMedicationName());
//        assertEquals("5", dto1.getDose());
//
//        // Valid patient with multiple prescriptions
//        Long patientId4 = 100000004L;
//        Patient patient4 = new Patient();
//        patient4.setSsn(patientId4);
//        patient4.setName("Dennis Doe");
//
//        Physician physician4 = new Physician();
//        physician4.setName("Molly Clock");
//        physician4.setPosition("Attending Psychiatrist");
//
//        Medication medication4 = new Medication();
//        medication4.setName("Thesisin");
//
//        Prescribes p1 = new Prescribes();
//        p1.setPatient(patientId4);
//        p1.setPatientDetails(patient4);
//        p1.setPhysicianDetails(physician4);
//        p1.setMedicationDetails(medication4);
//        p1.setDose("10");
//
//        Prescribes p2 = new Prescribes();
//        p2.setPatient(patientId4);
//        p2.setPatientDetails(patient4);
//        p2.setPhysicianDetails(physician4);
//        p2.setMedicationDetails(medication4);
//        p2.setDose("5");
//
//        when(prescribesRepo.findByPatient(patientId4)).thenReturn(Arrays.asList(p1, p2));
//
//        List<PrescriptionDTO> result4 = prescribeService.getPrescriptionsByPatientId(patientId4);
//        assertEquals(2, result4.size());
//        assertEquals("Dennis Doe", result4.get(0).getPatientName());
//        assertEquals("Molly Clock", result4.get(0).getPhysicianName());
//        assertEquals("Attending Psychiatrist", result4.get(0).getPhysicianPosition());
//        assertEquals("Thesisin", result4.get(0).getMedicationName());
//        assertEquals("10", result4.get(0).getDose());
//        
//        PrescriptionDTO dto2 = result4.get(1);
//        assertEquals("Dennis Doe", dto2.getPatientName());
//        assertEquals("Molly Clock", dto2.getPhysicianName());
//        assertEquals("Attending Psychiatrist", dto2.getPhysicianPosition());
//        assertEquals("Thesisin", dto2.getMedicationName());
//        assertEquals("5", dto2.getDose());
////
////        // Ensure data mismatch between patientId1 and patientId4
////        assertNotEquals(dto1.getPatientName(), result4.get(0).getPatientName());
////        assertNotEquals(dto1.getMedicationName(), result4.get(0).getMedicationName());
//
//        // Known patient IDs with no prescriptions
//        Long patientId2 = 100000002L;
//        Long patientId3 = 100000003L;
//
//        when(prescribesRepo.findByPatient(patientId2)).thenReturn(Collections.emptyList());
//        when(prescribesRepo.findByPatient(patientId3)).thenReturn(Collections.emptyList());
//
//        assertThrows(PrescriptionNotFoundException.class, () -> prescribeService.getPrescriptionsByPatientId(patientId2));
//        assertThrows(PrescriptionNotFoundException.class, () -> prescribeService.getPrescriptionsByPatientId(patientId3));
//
//        // Completely invalid patient ID
//        Long invalidPatientId = 10000001L;
//        when(prescribesRepo.findByPatient(invalidPatientId)).thenReturn(Collections.emptyList());
//
//        PrescriptionNotFoundException ex = assertThrows(PrescriptionNotFoundException.class,
//            () -> prescribeService.getPrescriptionsByPatientId(invalidPatientId));
//        assertEquals("No prescriptions found for patient with ID: " + invalidPatientId, ex.getMessage());
//    }
//}
//
//
//
package com.cg.hospital.ServiceImpl;

import com.cg.hospital.dto.PrescriptionDTO;
import com.cg.hospital.entity.*;
//import com.cg.hospital.exception.PrescriptionNotFoundException;
import com.cg.hospital.repository.PrescribesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
//import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PrescribeServiceImplTest {

    @Mock
    private PrescribesRepository prescribesRepo;

    @InjectMocks
    private PrescribeServiceImpl prescribeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPrescriptionsByPatientId_WithOnePrescription() {
        Long patientId = 100000001L;

        Patient patient = new Patient();
        patient.setSsn(patientId);
        patient.setName("John Smith");

        Physician physician = new Physician();
        physician.setName("John Dorian");
        physician.setPosition("Staff Internist");

        Medication medication = new Medication();
        medication.setName("Procrastin-X");

        Prescribes prescribes = new Prescribes();
        prescribes.setPatient(patientId);
        prescribes.setPatientDetails(patient);
        prescribes.setPhysicianDetails(physician);
        prescribes.setMedicationDetails(medication);
        prescribes.setDose("5");

        when(prescribesRepo.findByPatient(patientId)).thenReturn(List.of(prescribes));

        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);

        assertEquals(1, result.size());
        PrescriptionDTO dto = result.get(0);
        assertEquals("John Smith", dto.getPatientName());
        assertEquals("John Dorian", dto.getPhysicianName());
        assertEquals("Staff Internist", dto.getPhysicianPosition());
        assertEquals("Procrastin-X", dto.getMedicationName());
        assertEquals("5", dto.getDose());
    }


    @Test
    void testGetPrescriptionsByPatientId_WithMultiplePrescriptions() {
        Long patientId = 100000004L;

        Patient patient = new Patient();
        patient.setSsn(patientId);
        patient.setName("Dennis Doe");

        Physician physician1 = new Physician();
        physician1.setName("Molly Clock");
        physician1.setPosition("Attending Psychiatrist");

        Medication medication1 = new Medication();
        medication1.setName("Thesisin");

        Prescribes p1 = new Prescribes();
        p1.setPatient(patientId);
        p1.setPatientDetails(patient);
        p1.setPhysicianDetails(physician1);
        p1.setMedicationDetails(medication1);
        p1.setDose("10");

        Physician physician2 = new Physician();
        physician2.setName("Molly Clock");
        physician2.setPosition("Attending Psychiatrist");

        Medication medication2 = new Medication();
        medication2.setName("Thesisin");

        Prescribes p2 = new Prescribes();
        p2.setPatient(patientId);
        p2.setPatientDetails(patient);
        p2.setPhysicianDetails(physician2);
        p2.setMedicationDetails(medication2);
        p2.setDose("5");

        when(prescribesRepo.findByPatient(patientId)).thenReturn(Arrays.asList(p1, p2));

        List<PrescriptionDTO> result = prescribeService.getPrescriptionsByPatientId(patientId);

        assertEquals(2, result.size());

        PrescriptionDTO dto1 = result.get(0);
        assertEquals("Dennis Doe", dto1.getPatientName());
        assertEquals("Molly Clock", dto1.getPhysicianName());
        assertEquals("Attending Psychiatrist", dto1.getPhysicianPosition());
        assertEquals("Thesisin", dto1.getMedicationName());
        assertEquals("10", dto1.getDose());

        PrescriptionDTO dto2 = result.get(1);
        assertEquals("Dennis Doe", dto2.getPatientName());
        assertEquals("Molly Clock", dto2.getPhysicianName());
        assertEquals("Attending Psychiatrist", dto2.getPhysicianPosition());
        assertEquals("Thesisin", dto2.getMedicationName());
        assertEquals("5", dto2.getDose());

    }

}

