package com.vmo.fresher.controller;

import com.vmo.fresher.entity.Fresher;
import com.vmo.fresher.service.FresherService;
import lombok.RequiredArgsConstructor;
import model.request.FresherCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/freshers")
@RequiredArgsConstructor
public class FresherController {

    private final FresherService fresherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fresher> createFresher(@RequestBody @Valid FresherCreateRequest fresherCreateRequest) {
        Fresher savedFresher = fresherService.createFresher(fresherCreateRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedFresher.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> findAllFreshers(){
        return ResponseEntity.ok(fresherService.findAllFresher());
    }

}
