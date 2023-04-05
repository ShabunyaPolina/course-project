package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserRepository {

    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    void create(User user);

}
