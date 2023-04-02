package by.bsu.courseproject.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ModuleDto(
        //todo constraints

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        LibraryDto library,


        String name,
        String description,
        List<TagDto> tags

) {
}
