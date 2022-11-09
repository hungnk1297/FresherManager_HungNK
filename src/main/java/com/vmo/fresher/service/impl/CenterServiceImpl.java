package com.vmo.fresher.service.impl;

import com.vmo.fresher.entity.Center;
import com.vmo.fresher.repository.CenterRepository;
import com.vmo.fresher.service.CenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.request.CenterCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CenterServiceImpl implements CenterService {

    private final CenterRepository centerRepository;

    @Transactional
    @Override
    public Center createCenter(CenterCreateRequest centerCreateRequest) {
        var center = Center.builder()
                .name(centerCreateRequest.getName())
                .code(centerCreateRequest.getCode())
                .address(centerCreateRequest.getAddress())
                .dob(centerCreateRequest.getDob())
                .build();
        return centerRepository.save(center);
    }
}
