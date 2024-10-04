package org.maoco.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.maoco.controller.request.NewUserRequest;
import org.maoco.persistence.UserRepository;
import org.maoco.persistence.entity.UserEntity;

import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UUID create(NewUserRequest request) {
        return repository.save(UserEntity.of(request)).getId();
    }

    @Override
    public String delete(UUID id) {
        repository.deleteById(id);
        return String.format("Record was deleted by id %s", id);
    }

    @Override
    public UserEntity getById(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("Record not founded by id %s", id)));
    }
}
