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
    public RefreshmentPlan retrieveById(Long id) {
        return refreshmentPlanRepository.findById(id);
    }

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
    public void deleteById(Long id) {
        refreshmentPlanRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByModuleId(Long moduleId) {
        refreshmentPlanRepository.deleteByModuleId(moduleId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RefreshmentPlan> retrieveByStage(RefreshmentStage stage) {
        return refreshmentPlanRepository.findByStage(stage);
    }

    @Override
    @Transactional
    public void changeStage(Long id, Boolean isNext) { // TODO
        RefreshmentStage currentStage = retrieveById(id).getStage();
        RefreshmentStage newStage;

        if(isNext) {
            if(currentStage == RefreshmentStage.THIRD) {
                deleteById(id);
            } else {
                newStage = currentStage.next();
                refreshmentPlanRepository.changeStage(id, newStage);
            }
        } else {
            if(currentStage != RefreshmentStage.FIRST) {
                newStage = currentStage.next();
            }
            refreshmentPlanRepository.changeStage(id, newStage);
        }
    }

}
