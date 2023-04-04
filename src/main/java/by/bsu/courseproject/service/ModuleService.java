package by.bsu.courseproject.service;

import by.bsu.courseproject.model.Module;

import java.util.List;

public interface ModuleService {

    void create(Module module);

    List<Module> retrieveByLibraryId(Long libraryId);

}
