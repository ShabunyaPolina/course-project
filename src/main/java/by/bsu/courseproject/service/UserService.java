package by.bsu.courseproject.service;


import by.bsu.courseproject.model.User;

public interface UserService {

    User retrieveById(Long userId);

    User retrieveByEmail(String email);

    User create(User user);

}
