package com.vmo.fresher.controller;

import com.vmo.fresher.entity.Center;
import com.vmo.fresher.service.CenterFresherService;
import com.vmo.fresher.service.CenterService;
import lombok.RequiredArgsConstructor;
import model.request.CenterCreateRequest;
import model.response.CenterFresherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/centers")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;
    private final CenterFresherService centerFresherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Center> createCenter(@RequestBody @Valid CenterCreateRequest centerCreateRequest) {
        return ResponseEntity.ok(centerService.createCenter(centerCreateRequest));
    }

    @GetMapping("/{centerId}/freshers")
    public ResponseEntity<List<CenterFresherResponse>> getAllFresherByCenter(@PathVariable Long centerId) {
        return ResponseEntity.ok(centerFresherService.findAllFreshersByCenterId(centerId));
    }
}
