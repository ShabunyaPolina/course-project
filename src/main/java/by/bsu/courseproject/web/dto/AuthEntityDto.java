package by.bsu.courseproject.web.dto;

import by.bsu.courseproject.web.dto.group.OnAuthenticate;
import by.bsu.courseproject.web.dto.group.OnRefresh;
import by.bsu.courseproject.web.dto.group.OnRegister;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthEntityDto(

        @NotBlank(groups = OnRegister.class)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String name,

        @Email(groups = {OnRegister.class, OnAuthenticate.class})
        @NotBlank(groups = {OnRegister.class, OnAuthenticate.class})
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String email,

        @NotBlank(groups = {OnRegister.class, OnAuthenticate.class})
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String accessToken,

        @NotBlank(groups = {OnRefresh.class})
        String refreshToken

) {
}
