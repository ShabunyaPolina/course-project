package by.bsu.courseproject.service;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;

import java.util.List;

public interface RefreshmentPlanService {

    void considerRefreshment(Long moduleId, Boolean needsRefreshment);

    void createByModuleId(Long moduleId);

    void deleteByModuleId(Long moduleId);

    List<RefreshmentPlan> retrieveByStage(RefreshmentStage stage);

}
