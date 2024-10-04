package org.maoco.controller;

import lombok.RequiredArgsConstructor;
import org.maoco.controller.request.NewUserRequest;
import org.maoco.persistence.entity.UserEntity;
import org.maoco.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserEntity getMerchant(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody NewUserRequest request) {
        var response = userService.create(request);
        return ResponseEntity.accepted().body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        var response = userService.delete(id);
        return ResponseEntity.accepted().body(response);
    }
}
