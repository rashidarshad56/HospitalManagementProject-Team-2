package com.cg.hospital.service.impl;

import com.cg.hospital.dto.BlockDTO;
import com.cg.hospital.entity.Block;
import com.cg.hospital.repository.BlockRepository;
import com.cg.hospital.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public List<Integer> getAllBlockFloors() {
        return blockRepository.findAll()
                .stream()
                .map(Block::getBlockFloor)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<BlockDTO> getBlockCodesByFloor(Integer blockFloor) {
        return blockRepository.findByBlockFloor(blockFloor)
                .stream()
                .map(block -> new BlockDTO(block.getBlockFloor(), block.getBlockCode()))
                .collect(Collectors.toList());
    }
}