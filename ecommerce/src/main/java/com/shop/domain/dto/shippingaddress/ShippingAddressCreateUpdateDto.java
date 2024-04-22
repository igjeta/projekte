package com.shop.domain.dto.shippingaddress;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingAddressCreateUpdateDto {
    @NotBlank(message = "{validations.shippingAddresses.recipientName}")
    private String recipientName;

    @NotBlank(message = "{validations.shippingAddresses.addressLine1}")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "{validations.shippingAddresses.city}")
    private String city;

    @NotBlank(message = "{validations.shippingAddresses.stateProvince}")
    private String stateProvince;

    @NotBlank(message = "{validations.shippingAddresses.postalCode}")
    private String postalCode;

    @NotBlank(message = "{validations.shippingAddresses.country}")
    private String country;

    @NotBlank(message = "{validations.shippingAddresses.phoneNumber}")
    private String phoneNumber;
}
