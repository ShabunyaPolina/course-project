package by.bsu.courseproject.service;

import by.bsu.courseproject.model.Library;

public interface LibraryService {

    Library retrieveById(Long libraryId);

    void create(Library library);

}
