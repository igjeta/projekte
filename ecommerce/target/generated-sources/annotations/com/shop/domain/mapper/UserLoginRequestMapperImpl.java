package com.shop.domain.mapper;

import com.shop.domain.dto.request.UserLoginRequest;
import com.shop.domain.entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class UserLoginRequestMapperImpl implements UserLoginRequestMapper {

    @Override
    public UserEntity toEntity(UserLoginRequest req) {
        if ( req == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( req.getEmail() );
        userEntity.password( req.getPassword() );

        return userEntity.build();
    }
}
