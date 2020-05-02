package com.charmander.app.mapper;

import com.charmander.app.model.SignUpDto;
import com.charmander.app.model.UserDto;
import com.charmander.app.entity.User;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    User toUser (SignUpDto signUpDto);
    UserDto toDto (User user);
    List<UserDto> toDtos (Collection<User> users);
}
