package by.bsu.courseproject.web.dto;

import by.bsu.courseproject.web.dto.group.OnTag;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record TagDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(groups = {OnTag.class})
        String value

) {
}
