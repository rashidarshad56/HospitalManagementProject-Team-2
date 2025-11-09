package com.cg.hospital.serviceImplt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.hospital.dto.RoomDTO;
import com.cg.hospital.entity.Block;
import com.cg.hospital.entity.Room;
import com.cg.hospital.repository.BlockRepository;
import com.cg.hospital.repository.RoomRepository;
import com.cg.hospital.serviceImpl.RoomServiceImpl;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RoomServiceImplTest {

	@Mock
    private RoomRepository roomRepository;
    @Mock
    private BlockRepository blockRepository;
    @InjectMocks
    private RoomServiceImpl roomService;
 
    @Test
    void getRoomsByBlock_shouldReturnMappedDTOs() {
        // Mock block existence
        Block block = new Block();
        block.setBlockCode(1);
        block.setBlockFloor(1);
        when(blockRepository.findByBlockFloor(1)).thenReturn(List.of(block));
 
        // Mock room data
        Room room1 = new Room();
        room1.setRoomNumber(101);
        room1.setRoomType("Single");
        room1.setBlockFloor(1);
        room1.setBlockCode(1);
        room1.setUnavailable(false);
 
        Room room2 = new Room();
        room2.setRoomNumber(102);
        room2.setRoomType("Single");
        room2.setBlockFloor(1);
        room2.setBlockCode(1);
        room2.setUnavailable(true);
 
        when(roomRepository.findByBlockFloorAndBlockCode(1, 1)).thenReturn(List.of(room1, room2));
 
        // Call service
        List<RoomDTO> result = roomService.getRoomsByBlock(1, 1);
 
        // Assertions
        assertEquals(2, result.size());
        assertEquals(101, result.get(0).getRoomNumber());
        assertEquals("Single", result.get(0).getRoomType());
        assertFalse(result.get(0).getUnavailable());
 
        assertEquals(102, result.get(1).getRoomNumber());
        assertEquals("Single", result.get(1).getRoomType());
        assertTrue(result.get(1).getUnavailable());
    }
}
