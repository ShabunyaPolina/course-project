package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.service.RefreshmentPlanService;
import by.bsu.courseproject.web.dto.RefreshmentPlanDto;
import by.bsu.courseproject.web.dto.mapper.RefreshmentPlanMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/{refreshmentPlanId}")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasRefreshmentPlan(#libraryId,#refreshmentPlanId)
            """)
    public void changeStage(
            @PathVariable Long libraryId,
            @PathVariable Long refreshmentPlanId,
            @RequestParam Boolean isNext
    ) {
        refreshmentPlanService.changeStage(refreshmentPlanId, isNext);
    }

}
