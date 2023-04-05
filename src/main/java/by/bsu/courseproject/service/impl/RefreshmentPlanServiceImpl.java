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
//        refreshmentPlanRepository.createByModuleId(moduleId); todo
    }

    @Override
    @Transactional
    public void deleteByModuleId(Long moduleId) {
//        refreshmentPlanRepository.deleteByModuleId(moduleId); todo
    }

    @Override
    public List<RefreshmentPlan> retrieveByStage(RefreshmentStage stage) {
        return refreshmentPlanRepository.findByStage(stage);
    }


}
