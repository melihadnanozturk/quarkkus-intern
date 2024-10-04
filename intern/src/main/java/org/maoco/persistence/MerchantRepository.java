package org.maoco.persistence;

import org.maoco.persistence.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MerchantRepository extends JpaRepository<MerchantEntity, UUID> {
}
