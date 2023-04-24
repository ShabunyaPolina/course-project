package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.persistence.repository.RefreshmentPlanRepository;
import by.bsu.courseproject.service.RefreshmentPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefreshmentPlanServiceImpl implements RefreshmentPlanService {

    private final RefreshmentPlanRepository refreshmentPlanRepository;

    @Override
    @Transactional
    public void considerRefreshment(Long moduleId, Boolean needsRefreshment) {
        deleteByModuleId(moduleId);
        if (needsRefreshment) {
            createByModuleId(moduleId);
        }
    }

    @Override
    @Transactional
    public void createByModuleId(Long moduleId) {
        refreshmentPlanRepository.createByModuleId(moduleId);
    }

    @Override
    @Transactional
    public void deleteByModuleId(Long moduleId) {
        refreshmentPlanRepository.deleteByModuleId(moduleId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RefreshmentPlan> retrieveByStage(RefreshmentStage stage, Long libraryId) {
        return refreshmentPlanRepository.findByStage(stage,libraryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RefreshmentPlan> retrievePendingByLibrary(Long libraryId) {
        return refreshmentPlanRepository.findPendingByLibrary(libraryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RefreshmentPlan> retrievePendingByModule(Long moduleId) {
        return refreshmentPlanRepository.findPendingByModule(moduleId);
    }

}
