package com.cg.hospital.service.impl;

import com.cg.hospital.dto.BlockDTO;
import com.cg.hospital.entity.Block;
import com.cg.hospital.repository.BlockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlockServiceImplTesting {

    @Mock
    private BlockRepository blockRepository;

    @InjectMocks
    private BlockServiceImpl blockService;

    @Test
    void getAllBlockFloors_shouldReturnUniqueFloors() {
        List<Block> blocks = List.of(
            new Block(1, 1), new Block(1, 2), new Block(2, 1), new Block(3, 3)
        );
        when(blockRepository.findAll()).thenReturn(blocks);

        List<Integer> result = blockService.getAllBlockFloors();

        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void getBlockCodesByFloor_shouldReturnDTOs() {
        List<Block> blocks = List.of(
            new Block(2, 1), new Block(2, 2)
        );
        when(blockRepository.findByBlockFloor(2)).thenReturn(blocks);

        List<BlockDTO> result = blockService.getBlockCodesByFloor(2);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getBlockCode());
        assertEquals(2, result.get(1).getBlockCode());
    }
}