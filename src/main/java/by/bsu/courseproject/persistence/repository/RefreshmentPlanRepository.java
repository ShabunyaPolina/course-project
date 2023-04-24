package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefreshmentPlanRepository {

    RefreshmentPlan findById(Long id);

    List<RefreshmentPlan> findByStage(RefreshmentStage stage);

    void createByModuleId(Long moduleId);

    void deleteById(Long id);

    void deleteByModuleId(Long moduleId);

    void changeStage(Long id, RefreshmentStage stage);

}
