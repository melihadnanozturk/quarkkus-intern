package org.maoco.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.maoco.controller.request.NewUserRequest;

import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String surname;
    private Integer age;

    public static UserEntity of(NewUserRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .age(request.getAge())
                .build();
    }
}
