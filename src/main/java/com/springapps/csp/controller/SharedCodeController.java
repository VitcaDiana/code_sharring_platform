package com.springapps.csp.controller;

import com.springapps.csp.dto.SharedCodeRequestDTO;
import com.springapps.csp.model.SharedCode;
import com.springapps.csp.service.ShareCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SharedCodeController {
    private ShareCodeService shareCodeService;

    @Autowired
    public SharedCodeController(ShareCodeService shareCodeService) {
        this.shareCodeService = shareCodeService;
    }

    @PostMapping
    public ResponseEntity<SharedCode> addSharedCode(@RequestBody SharedCodeRequestDTO sharedCodeRequestDTO) {
        return ResponseEntity.ok(shareCodeService.addSharedCode(sharedCodeRequestDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SharedCode> getSharedCode(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(shareCodeService.getSharedCode(id));
    }
}
