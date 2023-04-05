package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ModuleRepository {

    void create(Module module);

    List<Module> findByLibraryId(Long libraryId);

    Optional<Module> findById(Long moduleId);

}
