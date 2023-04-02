package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.Module;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ModuleRepository {

    void create(Module module);

}
