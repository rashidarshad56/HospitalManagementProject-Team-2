package com.cg.hospital.SeviceImpl;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;
import com.cg.hospital.dto.PhysicianDTO;
import com.cg.hospital.entity.Department;
import com.cg.hospital.entity.Physician;
import com.cg.hospital.repository.DepartmentRepository;
import com.cg.hospital.repository.PhysicianRepository;
import com.cg.hospital.serviceImpl.PhysicianServiceImpl;
 
public class PhysicianServiceImplTest {
 
    @Mock
    private PhysicianRepository physicianRepo;
 
    @Mock
    private DepartmentRepository departmentRepo;
 
    @InjectMocks
    private PhysicianServiceImpl physicianService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testGetAllPhysicians() {
        Physician p1 = new Physician();
        p1.setEmployeeId(1);
        p1.setName("John Dorian");
        p1.setPosition("Staff Internist");
 
        Physician p2 = new Physician();
        p2.setEmployeeId(2);
        p2.setName("Elliot Reid");
        p2.setPosition("Attending Physician");
 
        when(physicianRepo.findAll()).thenReturn(Arrays.asList(p1, p2));
 
        List<PhysicianDTO> result = physicianService.getAllPhysicians();
 
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getEmployeeId());
        assertEquals("John Dorian", result.get(0).getName());
        assertEquals("Attending Physician", result.get(1).getPosition());
 
        verify(physicianRepo, times(1)).findAll();
    }
 
    @Test
    void testGetPhysiciansByDepartment() {
        Department dept = new Department();
        dept.setDepartmentId(10);
        dept.setName("Cardiology");
 
        Physician p1 = new Physician();
        p1.setEmployeeId(3);
        p1.setName("Christopher Turk");
        p1.setPosition("Surgical Attending Physician");
 
        Physician p2 = new Physician();
        p2.setEmployeeId(4);
        p2.setName("Percival Cox");
        p2.setPosition("Senior Attending Physician");
 
        when(departmentRepo.findById(10)).thenReturn(Optional.of(dept));
        when(physicianRepo.findByAffiliationsDepartmentDepartmentId(10))
                .thenReturn(Arrays.asList(p1, p2));
 
        DepartmentPhysicianResponseDTO response = physicianService.getPhysiciansByDepartment(10);
 
        assertEquals("Cardiology", response.getDepartmentName());
        assertEquals(2, response.getPhysicians().size());
        assertEquals("Christopher Turk", response.getPhysicians().get(0).getName());
        assertEquals("Senior Attending Physician", response.getPhysicians().get(1).getPosition());
 
        verify(departmentRepo, times(1)).findById(10);
        verify(physicianRepo, times(1)).findByAffiliationsDepartmentDepartmentId(10);
    }
}