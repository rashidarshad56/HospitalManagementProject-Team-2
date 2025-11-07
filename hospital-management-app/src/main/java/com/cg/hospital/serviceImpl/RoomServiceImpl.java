package com.cg.hospital.serviceImpl;

import com.cg.hospital.dto.RoomDTO;
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

    @Override
    public List<RoomDTO> getRoomsByBlock(Integer blockFloor, Integer blockCode) {
        return roomRepository.findByBlockFloorAndBlockCode(blockFloor, blockCode)
                .stream()
                .map(room -> new RoomDTO(room.getRoomNumber(), room.getRoomType(), room.getUnavailable()))
                .collect(Collectors.toList());
    }

}
