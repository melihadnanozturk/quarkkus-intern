package org.maoco.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.maoco.controller.request.NewMerchantRequest;

import java.util.UUID;

@Entity
@Table(name = "merchant")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String title;
    private String ownerName;
    private String ownerSurname;
    private String representativeName;
    private String representativeSurname;
    private String job;

    public static MerchantEntity of(NewMerchantRequest request) {
        return MerchantEntity.builder()
                .title(request.getTitle())
                .job(request.getJob())
                .ownerName(request.getOwnerName())
                .ownerSurname(request.getOwnerSurname())
                .representativeName(request.getRepresentativeName())
                .representativeSurname(request.getRepresentativeSurname())
                .build();
    }


}
