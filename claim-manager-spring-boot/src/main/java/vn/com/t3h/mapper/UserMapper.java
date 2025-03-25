package vn.com.t3h.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "code", target = "code")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(target = "fullname", expression = "java(userEntity.getFirstName() + \" \" + userEntity.getLastName())")
    @Mapping(source = "address", target = "address")
    UserDTO toDto(UserEntity userEntity);
}
