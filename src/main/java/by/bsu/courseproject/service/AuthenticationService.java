package by.bsu.courseproject.service;


import by.bsu.courseproject.model.AuthEntity;

public interface AuthenticationService {

    AuthEntity register(AuthEntity request);

    AuthEntity authenticate(AuthEntity request);

    AuthEntity refresh(AuthEntity authEntity);

}
