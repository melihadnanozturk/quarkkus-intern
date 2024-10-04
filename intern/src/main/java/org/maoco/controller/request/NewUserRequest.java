package org.maoco.controller.request;

import lombok.Data;

@Data
public class NewUserRequest {

    private String name;
    private String surname;
    private Integer age;
}
