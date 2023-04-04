package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface TagRepository {

    Optional<Tag> findByValue(String value);

    void create(Tag tag);

    void addTagToModule(Long tagId, Long moduleId);

}
