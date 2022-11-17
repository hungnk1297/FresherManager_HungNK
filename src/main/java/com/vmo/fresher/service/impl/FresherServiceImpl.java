package com.vmo.fresher.service.impl;

import com.vmo.fresher.entity.Fresher;
import com.vmo.fresher.exception.ApiErrorDetail;
import com.vmo.fresher.exception.EntityNotFoundException;
import com.vmo.fresher.repository.FresherRepository;
import com.vmo.fresher.service.FresherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.request.FresherCreateRequest;
import model.response.FresherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FresherServiceImpl implements FresherService {

    private final FresherRepository fresherRepository;

    @Override
    @Transactional
    public Fresher createFresher(FresherCreateRequest fresherCreateRequest) {
        Fresher fresher = Fresher.builder()
                .name(fresherCreateRequest.getName())
                .phone(fresherCreateRequest.getPhone())
                .email(fresherCreateRequest.getEmail())
                .dob(fresherCreateRequest.getDob())
                .address(fresherCreateRequest.getAddress())
                .build();
        return fresherRepository.save(fresher);
    }

    @Override
    public List<String> findAllFresher() {
        return fresherRepository.findAll().stream().map(Fresher::getName).collect(Collectors.toList());
    }

    @Override
    public FresherResponse findById(Long fresherId) {
        Fresher fresher = fresherRepository.findById(fresherId)
                .orElseThrow(() -> new EntityNotFoundException(ApiErrorDetail.builder()
                        .message("Fresher Not Found!")
                        .entityName("Fresher")
                        .fieldName("Id")
                        .fieldValue(fresherId)
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build()));

        return FresherResponse.builder()
                .fresherId(fresher.getId())
                .fresherName(fresher.getName())
                .address(fresher.getAddress())
                .phone(fresher.getPhone())
                .email(fresher.getEmail())
                .dob(fresher.getDob())
                .build();
    }
}
