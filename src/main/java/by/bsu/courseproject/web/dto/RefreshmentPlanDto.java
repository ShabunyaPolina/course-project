package by.bsu.courseproject.web.dto;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.web.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RefreshmentPlanDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        CardDto card,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        LocalDateTime refreshTime,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        RefreshmentStage stage

) {
}
