package org.maoco.service;

import org.maoco.controller.request.NewUserRequest;
import org.maoco.persistence.entity.UserEntity;

import java.util.UUID;

public interface UserService {

    UUID create(NewUserRequest request);

    String delete(UUID id);

    UserEntity getById(UUID id);
}
