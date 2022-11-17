package com.vmo.fresher.service;

import com.vmo.fresher.entity.Fresher;
import model.request.FresherCreateRequest;
import model.response.FresherResponse;

import java.util.List;

public interface FresherService {

    Fresher createFresher(FresherCreateRequest fresherCreateRequest);

    List<String> findAllFresher();

    FresherResponse findById(Long fresherId);

}
