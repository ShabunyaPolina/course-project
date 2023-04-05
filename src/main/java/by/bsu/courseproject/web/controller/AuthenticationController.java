package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.AuthEntity;
import by.bsu.courseproject.service.AuthenticationService;
import by.bsu.courseproject.web.dto.AuthEntityDto;
import by.bsu.courseproject.web.dto.group.OnAuthenticate;
import by.bsu.courseproject.web.dto.group.OnRefresh;
import by.bsu.courseproject.web.dto.group.OnRegister;
import by.bsu.courseproject.web.dto.mapper.AuthEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthEntityMapper authEntityMapper;

    @PostMapping("/register")
    public AuthEntityDto register(@Validated(OnRegister.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.register(authEntity)
        );
    }

    @PostMapping("/authenticate")
    public AuthEntityDto authenticate(@Validated(OnAuthenticate.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.authenticate(authEntity)
        );
    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@Validated(OnRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.refresh(authEntity)
        );
    }

}
