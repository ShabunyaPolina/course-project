package by.bsu.courseproject.web.dto;

import by.bsu.courseproject.web.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record CardDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        ModuleDto module,

        @NotBlank(groups = {OnCreate.class})
        String term,

        @NotBlank(groups = {OnCreate.class})
        String definition,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Boolean isMemorised

) {
}
