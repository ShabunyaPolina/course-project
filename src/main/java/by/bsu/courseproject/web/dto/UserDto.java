package by.bsu.courseproject.web.dto;

import by.bsu.courseproject.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,
        String name,
        String email,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password,

        Role role

) {
}
