package by.bsu.courseproject.service;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;

import java.util.List;

public interface RefreshmentPlanService {

    RefreshmentPlan retrieveById(Long id);

    void considerRefreshment(Long moduleId, Boolean needsRefreshment);

    void createByModuleId(Long moduleId);

    void deleteById(Long id);

    void deleteByModuleId(Long moduleId);

    List<RefreshmentPlan> retrieveByStage(RefreshmentStage stage, Long libraryId);

    List<RefreshmentPlan> retrievePendingByLibrary(Long libraryId);

    List<RefreshmentPlan> retrievePendingByModule(Long moduleId);

    void changeStage(Long refreshmentPlanId, Boolean isNext);

}
