package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.User;
import by.bsu.courseproject.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserDto dto);

    UserDto toDto(User model);

}
