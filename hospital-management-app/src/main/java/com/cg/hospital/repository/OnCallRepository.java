package com.cg.hospital.repository;

import com.cg.hospital.entity.OnCall;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnCallRepository extends JpaRepository<OnCall, Long> {
    List<OnCall> findByNurseId(Integer nurseId);
}
