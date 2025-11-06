package com.cg.hospital.repository;

import com.cg.hospital.entity.Block;
import com.cg.hospital.entity.BlockId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, BlockId> {
    List<Block> findByBlockFloor(Integer blockFloor);
}