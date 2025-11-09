package com.cg.hospital.serviceImpl;

import com.cg.hospital.entity.OnCall;
import com.cg.hospital.repository.OnCallRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OnCallServiceImplTest {

    @Mock
    private OnCallRepository onCallRepository;

    @InjectMocks
    private OnCallServiceImpl onCallService;

    @Test
    void getOnCallsByNurseId_shouldReturnCorrectData() {
        // Create mock OnCall records
        OnCall onCall1 = new OnCall();
        onCall1.setId(1L);
        onCall1.setNurseId(101);
        onCall1.setOnCallStart(LocalDateTime.of(2008, 11, 4, 11, 0));
        onCall1.setOnCallEnd(LocalDateTime.of(2008, 11, 4, 19, 0));

        OnCall onCall2 = new OnCall();
        onCall2.setId(2L);
        onCall2.setNurseId(101);
        onCall2.setOnCallStart(LocalDateTime.of(2008, 11, 5, 11, 0));
        onCall2.setOnCallEnd(LocalDateTime.of(2008, 11, 5, 19, 0));

        // Mock repository behavior
        when(onCallRepository.findByNurseId(101)).thenReturn(List.of(onCall1, onCall2));

        // Call service method
        List<OnCall> result = onCallService.getOnCallsByNurseId(101);

        // Assertions
        assertEquals(2, result.size());

        assertEquals(LocalDateTime.of(2008, 11, 4, 11, 0), result.get(0).getOnCallStart());
        assertEquals(LocalDateTime.of(2008, 11, 5, 19, 0), result.get(1).getOnCallEnd());
    }
}
