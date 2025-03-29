package vn.com.t3h.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDTO userDTO);

    @Mapping(source = "username",target = "username")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "code",target = "code")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "phone",target = "phone")
    @Mapping(source = "address",target = "address")
    @Mapping(source = "pathAvatar",target = "stringBase64Avatar")
    @Mapping(source = "createdDate",target = "createdDate")
    UserDTO toDto(UserEntity userEntity);
}