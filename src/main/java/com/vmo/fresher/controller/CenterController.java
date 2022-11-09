package com.vmo.fresher.controller;

import com.vmo.fresher.entity.Center;
import com.vmo.fresher.service.CenterService;
import lombok.RequiredArgsConstructor;
import model.request.CenterCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/centers")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Center> createCenter(@RequestBody @Valid CenterCreateRequest centerCreateRequest) {
        return ResponseEntity.ok(centerService.createCenter(centerCreateRequest));
    }
}
