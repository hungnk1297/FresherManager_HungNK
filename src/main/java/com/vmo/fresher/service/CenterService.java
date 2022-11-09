package com.vmo.fresher.service;

import com.vmo.fresher.entity.Center;
import model.request.CenterCreateRequest;

public interface CenterService {

    Center createCenter(CenterCreateRequest centerCreateRequest);
}
