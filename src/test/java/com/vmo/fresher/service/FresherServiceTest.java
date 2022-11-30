package com.vmo.fresher.service;

import com.vmo.fresher.entity.Fresher;
import com.vmo.fresher.exception.EntityNotFoundException;
import com.vmo.fresher.repository.FresherRepository;
import model.response.FresherResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class FresherServiceTest {

    @Autowired
    private FresherService fresherService;

    @MockBean
    FresherRepository fresherRepository;

    @Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        Fresher johnFresher = Fresher.builder()
                .id(1L).name("John").address("123 Street").email("john@email.com")
                .build();

        // Return the mocked data when retrieving
        when(fresherRepository.findById(1L)).thenReturn(Optional.of(johnFresher));

        //  Execute the service call
        FresherResponse returnedFresher = fresherService.findById(1L);

        assertNotNull(returnedFresher, "Fresher was not found!");
        assertEquals(johnFresher.getName(), returnedFresher.fresherName());
        assertEquals(johnFresher.getId(), returnedFresher.fresherId());
    }

    @Test
    @DisplayName("Test findById Fail")
    void testFindByIdFail() {
        // Return the mocked data when retrieving
        when(fresherRepository.findById(anyLong())).thenReturn(Optional.empty());

        //  Expect fail
        assertThrows(EntityNotFoundException.class, () -> {
            fresherService.findById(1L);
        });
    }
}
