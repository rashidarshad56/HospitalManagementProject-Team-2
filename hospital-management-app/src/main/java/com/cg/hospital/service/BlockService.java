package com.cg.hospital.service;

import com.cg.hospital.dto.BlockDTO;

import java.util.List;

public interface BlockService {
    List<Integer> getAllBlockFloors();
    List<BlockDTO> getBlockCodesByFloor(Integer blockFloor);
}