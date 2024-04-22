package com.shop.domain.mapper;

import com.shop.domain.dto.request.UserLoginRequest;
import com.shop.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserLoginRequestMapper{

    UserLoginRequestMapper USER_LOGIN_REQUEST_MAPPER = Mappers.getMapper(UserLoginRequestMapper.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    UserEntity toEntity(UserLoginRequest req);
}
