package com.cg.hospital.repository;

import com.cg.hospital.entity.Affiliation;
import com.cg.hospital.entity.AffiliationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffiliationRepository extends JpaRepository<Affiliation, AffiliationId> {
}
