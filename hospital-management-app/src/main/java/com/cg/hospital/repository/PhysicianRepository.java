package com.cg.hospital.repository;
 
import com.cg.hospital.dto.PhysicianDTO;
import com.cg.hospital.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
 
public interface PhysicianRepository extends JpaRepository<Physician, Integer> {
 
    // Fetch physicians by department ID
    @Query("SELECT new com.cg.hospital.dto.PhysicianDTO(p.name, p.position) " +
           "FROM Physician p JOIN p.affiliations a WHERE a.department.departmentId = :deptId")
    List<PhysicianDTO> findPhysiciansByDepartmentId(@Param("deptId") Integer deptId);
    List<Physician> findByAffiliationsDepartmentDepartmentId(Integer departmentId);
 
}