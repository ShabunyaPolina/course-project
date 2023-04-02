package by.bsu.courseproject.service;

import by.bsu.courseproject.model.Tag;

public interface TagService {

    void addTagToModule(Long tagId, Long moduleId);

    void createIfNotExists(Tag tag);

    void create(Tag tag);

}
