package com.shop.domain.mapper;

import com.shop.domain.dto.shippingaddress.ShippingAddressCreateUpdateDto;
import com.shop.domain.dto.shippingaddress.ShippingAddressDto;
import com.shop.domain.entity.ShippingAddressEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class ShippingAddressMapperImpl implements ShippingAddressMapper {

    @Override
    public ShippingAddressEntity toEntity(ShippingAddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        ShippingAddressEntity.ShippingAddressEntityBuilder shippingAddressEntity = ShippingAddressEntity.builder();

        shippingAddressEntity.id( dto.getId() );
        shippingAddressEntity.recipientName( dto.getRecipientName() );
        shippingAddressEntity.addressLine1( dto.getAddressLine1() );
        shippingAddressEntity.addressLine2( dto.getAddressLine2() );
        shippingAddressEntity.city( dto.getCity() );
        shippingAddressEntity.stateProvince( dto.getStateProvince() );
        shippingAddressEntity.postalCode( dto.getPostalCode() );
        shippingAddressEntity.country( dto.getCountry() );
        shippingAddressEntity.phoneNumber( dto.getPhoneNumber() );

        return shippingAddressEntity.build();
    }

    @Override
    public ShippingAddressEntity toEntityCrud(ShippingAddressCreateUpdateDto dto) {
        if ( dto == null ) {
            return null;
        }

        ShippingAddressEntity.ShippingAddressEntityBuilder shippingAddressEntity = ShippingAddressEntity.builder();

        shippingAddressEntity.recipientName( dto.getRecipientName() );
        shippingAddressEntity.addressLine2( dto.getAddressLine2() );
        shippingAddressEntity.city( dto.getCity() );
        shippingAddressEntity.stateProvince( dto.getStateProvince() );
        shippingAddressEntity.postalCode( dto.getPostalCode() );
        shippingAddressEntity.country( dto.getCountry() );
        shippingAddressEntity.phoneNumber( dto.getPhoneNumber() );

        return shippingAddressEntity.build();
    }

    @Override
    public ShippingAddressDto toDTO(ShippingAddressEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ShippingAddressDto.ShippingAddressDtoBuilder shippingAddressDto = ShippingAddressDto.builder();

        shippingAddressDto.id( entity.getId() );
        shippingAddressDto.recipientName( entity.getRecipientName() );
        shippingAddressDto.addressLine1( entity.getAddressLine1() );
        shippingAddressDto.addressLine2( entity.getAddressLine2() );
        shippingAddressDto.city( entity.getCity() );
        shippingAddressDto.stateProvince( entity.getStateProvince() );
        shippingAddressDto.postalCode( entity.getPostalCode() );
        shippingAddressDto.country( entity.getCountry() );
        shippingAddressDto.phoneNumber( entity.getPhoneNumber() );

        return shippingAddressDto.build();
    }
}
