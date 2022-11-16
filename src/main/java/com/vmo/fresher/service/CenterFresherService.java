package com.vmo.fresher.service;

import com.vmo.fresher.entity.CenterFresher;
import model.response.CenterFresherResponse;

import java.util.List;

public interface CenterFresherService {

    List<CenterFresherResponse> findAllFreshersByCenterId(Long centerId);
}
