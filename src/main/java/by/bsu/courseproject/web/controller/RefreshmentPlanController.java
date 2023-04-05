package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.service.RefreshmentPlanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import by.bsu.courseproject.web.dto.RefreshmentPlanDto;
import by.bsu.courseproject.web.dto.mapper.ModuleMapper;
import by.bsu.courseproject.web.dto.mapper.RefreshmentPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}/refreshment-plans")
@SecurityRequirement(name = "Bearer Authentication")
public class RefreshmentPlanController {

    private final RefreshmentPlanService refreshmentPlanService;
    private final RefreshmentPlanMapper refreshmentPlanMapper;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<RefreshmentPlanDto> getByStage(@RequestParam RefreshmentStage stage) {
        return refreshmentPlanService.retrieveByStage(stage).stream()
                .map(refreshmentPlanMapper::toDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void considerRefreshment(@RequestParam Long moduleId,
                                    @RequestParam Boolean needsRefreshment) {
        refreshmentPlanService.considerRefreshment(moduleId, needsRefreshment);
    }

}
