package by.bsu.courseproject.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LibraryDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UserDto user,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Double rating

) {
}
