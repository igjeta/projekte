package com.shop.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @Email(message = "{validations.user.create.email}")
    @NotBlank(message = "{validations.user.create.email}")
    private String email;

    @NotBlank(message = "{validations.user.create.password}")
    private String password;

    @NotBlank(message = "{validations.user.create.firstName}")
    private String firstName;

    @NotBlank(message = "{validations.user.create.lastName}")
    private String lastName;

    @NotBlank(message = "{validations.user.create.phoneNumber}")
    private String phoneNumber;
}
