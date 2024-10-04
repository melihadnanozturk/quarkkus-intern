package org.maoco.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.maoco.controller.request.NewMerchantRequest;
import org.maoco.persistence.MerchantRepository;
import org.maoco.persistence.entity.MerchantEntity;

import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository repository;


    @Override
    public UUID create(NewMerchantRequest request) {
        return repository.save(MerchantEntity.of(request)).getUuid();
    }

    @Override
    public String delete(UUID id) {
        repository.deleteById(id);
        return String.format("record deleted by %s", id.toString());
    }

    @Override
    public MerchantEntity getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Record not founded %s", id)));
    }
}
