package com.shop.domain.mapper;

import com.shop.domain.dto.user.UserCreateDto;
import com.shop.domain.dto.user.UserUpdateDto;
import com.shop.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper{

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserEntity toEntityCreate(UserCreateDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserEntity toEntityUpdate(UserUpdateDto dto);

}
