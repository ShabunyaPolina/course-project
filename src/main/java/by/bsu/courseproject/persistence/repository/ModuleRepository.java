package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModuleRepository {

    void create(Module module);

    List<Module> findByLibraryId(Long libraryId);

}
