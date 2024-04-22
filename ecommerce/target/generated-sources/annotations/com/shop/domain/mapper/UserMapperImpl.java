package com.shop.domain.mapper;

import com.shop.domain.dto.user.UserCreateDto;
import com.shop.domain.dto.user.UserUpdateDto;
import com.shop.domain.entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntityCreate(UserCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.firstName( dto.getFirstName() );
        userEntity.lastName( dto.getLastName() );
        userEntity.phoneNumber( dto.getPhoneNumber() );

        return userEntity.build();
    }

    @Override
    public UserEntity toEntityUpdate(UserUpdateDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.firstName( dto.getFirstName() );
        userEntity.lastName( dto.getLastName() );
        userEntity.phoneNumber( dto.getPhoneNumber() );

        return userEntity.build();
    }
}
