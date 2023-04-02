package by.bsu.courseproject.web.dto;

import by.bsu.courseproject.model.Role;

public record UserDto(
        //todo constraints

        Long id,
        String name,
        String email,
        String password,
        Role role

) {
}
