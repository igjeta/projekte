package com.shop.domain.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {

    @NotBlank(message = "{validations.user.create.password}")
    private String password;

    @NotBlank(message = "{validations.user.create.firstName}")
    private String firstName;

    @NotBlank(message = "{validations.user.create.lastName}")
    private String lastName;

    @NotBlank(message = "{validations.user.create.phoneNumber}")
    private String phoneNumber;
}
