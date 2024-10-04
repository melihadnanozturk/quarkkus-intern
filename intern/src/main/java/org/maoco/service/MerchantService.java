package org.maoco.service;

import org.maoco.controller.request.NewMerchantRequest;
import org.maoco.persistence.entity.MerchantEntity;

import java.util.UUID;

public interface MerchantService {


    UUID create(NewMerchantRequest request);

    String delete(UUID id);

    MerchantEntity getById(UUID id);
}
