package org.maoco.controller;

import lombok.RequiredArgsConstructor;
import org.maoco.controller.request.NewMerchantRequest;
import org.maoco.persistence.entity.MerchantEntity;
import org.maoco.service.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/{id}")
    public MerchantEntity getMerchant(@PathVariable UUID id) {
        return merchantService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createNewMerchant(@RequestBody NewMerchantRequest request) {
        var response = merchantService.create(request);
        return ResponseEntity.accepted().body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMerchant(@PathVariable UUID id) {
        var response = merchantService.delete(id);
        return ResponseEntity.accepted().body(response);
    }
}
