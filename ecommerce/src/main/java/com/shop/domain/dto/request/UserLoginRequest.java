package com.shop.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    @Email(message = "{validations.user.create.email}")
    @NotBlank(message = "{validations.user.create.email}")
    private String email;

    @NotBlank(message = "{validations.user.create.password}")
    private String password;
}
