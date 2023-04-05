package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.User;
import by.bsu.courseproject.model.exception.ResourceNotFoundException;
import by.bsu.courseproject.model.exception.UniqueResourceException;
import by.bsu.courseproject.persistence.repository.UserRepository;
import by.bsu.courseproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User retrieveById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesn't exist!"));
    }

    @Override
    @Transactional(readOnly = true)
    public User retrieveByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
    }

    @Override
    @Transactional
    public User create(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UniqueResourceException("User with email " + user.getEmail() + " already exists!");
        }
        userRepository.create(user);
        return user;
    }

}
