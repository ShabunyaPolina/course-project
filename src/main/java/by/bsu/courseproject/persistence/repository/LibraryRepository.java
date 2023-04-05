package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.Library;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface LibraryRepository {

    Optional<Library> findById(Long libraryId);

    void create(Library library);

}
