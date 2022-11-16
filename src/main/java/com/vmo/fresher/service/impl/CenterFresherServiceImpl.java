package com.vmo.fresher.service.impl;

import com.vmo.fresher.entity.CenterFresher;
import com.vmo.fresher.repository.CenterFreshRepository;
import com.vmo.fresher.service.CenterFresherService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.response.CenterFresherResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CenterFresherServiceImpl implements CenterFresherService {

    private final CenterFreshRepository centerFreshRepository;

    @Override
    public List<CenterFresherResponse> findAllFreshersByCenterId(Long centerId) {
        return centerFreshRepository.findAllByCenterId(centerId).stream()
                .map(centerFresher -> CenterFresherResponse.builder()
                        .centerId(centerFresher.getCenter().getId())
                        .centerName(centerFresher.getCenter().getName())
                        .fresherId(centerFresher.getFresher().getId())
                        .fresherName(centerFresher.getFresher().getName()).build())
                .collect(Collectors.toList());
    }

}
