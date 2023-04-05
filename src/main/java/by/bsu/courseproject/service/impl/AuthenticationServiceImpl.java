package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.AuthEntity;
import by.bsu.courseproject.model.Role;
import by.bsu.courseproject.model.User;
import by.bsu.courseproject.service.AuthenticationService;
import by.bsu.courseproject.service.UserService;
import by.bsu.courseproject.web.security.JwtManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtManager jwtManager;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthEntity register(AuthEntity authEntity) {
        User user = User.builder()
                .name(authEntity.getName())
                .email(authEntity.getEmail())
                .password(passwordEncoder.encode(authEntity.getPassword()))
                .role(Role.USER)
                .build();
        userService.create(user);
        String accessJwt = jwtManager.generateAccessToken(user);
        String refreshJwt = jwtManager.generateRefreshToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public AuthEntity authenticate(AuthEntity authEntity) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authEntity.getEmail(),
                        authEntity.getPassword()
                )
        );
        User user = userService.retrieveByEmail(authEntity.getEmail());
        String accessJwt = jwtManager.generateAccessToken(user);
        String refreshJwt = jwtManager.generateRefreshToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public AuthEntity refresh(AuthEntity authEntity) {
        String refreshToken = authEntity.getRefreshToken();
        if (!jwtManager.isValidRefreshToken(refreshToken)) {
            throw new AccessDeniedException("Access denied!");
        }
        String email = jwtManager.extractRefreshSubject(refreshToken);
        User user = userService.retrieveByEmail(email);
        String accessToken = jwtManager.generateAccessToken(user);
        String newRefreshToken = jwtManager.generateRefreshToken(user);
        return AuthEntity.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .build();
    }

}
