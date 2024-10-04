package org.maoco.controller.request;

import lombok.Data;

@Data
public class NewMerchantRequest {

    private String title;
    private String ownerName;
    private String ownerSurname;
    private String representativeName;
    private String representativeSurname;
    private String job;

}
