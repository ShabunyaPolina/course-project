package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefreshmentPlanRepository {

    List<RefreshmentPlan> findByStage(RefreshmentStage stage);

    void createByModuleId(Long moduleId);

    void deleteByModuleId(Long moduleId);

}
