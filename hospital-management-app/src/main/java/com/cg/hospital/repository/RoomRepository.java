package com.cg.hospital.repository;

import com.cg.hospital.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByBlockFloorAndBlockCode(Integer blockFloor, Integer blockCode);
}