package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.service.RefreshmentPlanService;
import by.bsu.courseproject.web.dto.RefreshmentPlanDto;
import by.bsu.courseproject.web.dto.mapper.RefreshmentPlanMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}")
@SecurityRequirement(name = "Bearer Authentication")
public class RefreshmentPlanController {

    private final RefreshmentPlanService refreshmentPlanService;
    private final RefreshmentPlanMapper refreshmentPlanMapper;

    @Operation(
            summary = "Get all cards by refreshment stage"
    )
    @GetMapping("/refreshment-plans")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("@securityExpressions.hasLibrary(#libraryId)")
    public List<RefreshmentPlanDto> getByStage(@RequestParam RefreshmentStage stage, @PathVariable Long libraryId) {
        return refreshmentPlanService.retrieveByStage(stage, libraryId).stream()
                .map(refreshmentPlanMapper::toDto)
                .toList();
    }

    @PostMapping("/refreshment-plans/{refreshmentPlanId}")
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
    
    @GetMapping("/refreshment-plans/pending")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("@securityExpressions.hasLibrary(#libraryId)")
    public List<RefreshmentPlanDto> getPendingByLibrary(@PathVariable Long libraryId) {
        return refreshmentPlanService.retrievePendingByLibrary(libraryId).stream()
                .map(refreshmentPlanMapper::toDto)
                .toList();
    }

    @GetMapping("/modules/{moduleId}/refreshment-plans/pending")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasModule(#libraryId,#moduleId)
            """)
    public List<RefreshmentPlanDto> getPendingByModule(@PathVariable Long libraryId, @PathVariable Long moduleId) {
        return refreshmentPlanService.retrievePendingByModule(moduleId).stream()
                .map(refreshmentPlanMapper::toDto)
                .toList();
    }

}
