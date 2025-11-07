package com.cg.hospital.repository;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.cg.hospital.entity.Stay;

	import java.util.List;

	@Repository
	public interface StayRepository extends JpaRepository<Stay, Integer> {
		List<Stay> findByPatient_Ssn(int ssn);


	

}
