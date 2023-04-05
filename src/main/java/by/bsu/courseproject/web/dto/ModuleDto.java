package by.bsu.courseproject.web.dto;


import by.bsu.courseproject.web.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ModuleDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        LibraryDto library,

        @NotBlank(groups = {OnCreate.class})
        String name,

        @NotBlank(groups = {OnCreate.class})
        String description,

        @NotNull(groups = {OnCreate.class})
        List<TagDto> tags

) {
}
