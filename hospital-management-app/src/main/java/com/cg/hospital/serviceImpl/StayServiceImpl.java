package com.cg.hospital.service.impl;

	import com.cg.hospital.entity.Stay;
	import com.cg.hospital.repository.StayRepository;
	import com.cg.hospital.service.StayService;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;

	@Service
	public class StayServiceImpl implements StayService {

	    @Autowired
	    private StayRepository stayRepository;

	    @Override
	    public List<Stay> getAllStays() {
	        return stayRepository.findAll();
	    }

	    @Override
	    public List<Stay> getStaysByPatientSsn(int ssn) {
	        return stayRepository.findByPatient_Ssn(ssn);
	    }
	

}
