package com.cg.hospital.serviceImpl;

import com.cg.hospital.dto.RoomDTO;
import com.cg.hospital.entity.Block;
import com.cg.hospital.exception.BlockNotFoundException;
import com.cg.hospital.repository.BlockRepository;
import com.cg.hospital.repository.RoomRepository;
import com.cg.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BlockRepository blockRepository;
    @Override
    public List<RoomDTO> getRoomsByBlock(Integer blockFloor, Integer blockCode) {
        List<Block> blocks = blockRepository.findByBlockFloor(blockFloor);
        boolean blockCodeExists = blocks.stream().anyMatch(b -> b.getBlockCode().equals(blockCode));

        if (blocks.isEmpty()) {
            throw new BlockNotFoundException("Invalid Block: BlockFloor " + blockFloor + " does not exist.");
        } else if (!blockCodeExists) {
            throw new BlockNotFoundException("BlockCode " + blockCode + " does not exist for BlockFloor " + blockFloor + ".");
        }

        return roomRepository.findByBlockFloorAndBlockCode(blockFloor, blockCode)
                .stream()
                .map(room -> new RoomDTO(room.getRoomNumber(), room.getRoomType(), room.getUnavailable()))
                .collect(Collectors.toList());
    }
}