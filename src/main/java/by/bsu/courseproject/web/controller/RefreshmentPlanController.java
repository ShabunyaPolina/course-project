package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.service.RefreshmentPlanService;
import by.bsu.courseproject.web.dto.RefreshmentPlanDto;
import by.bsu.courseproject.web.dto.mapper.RefreshmentPlanMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @Operation(
            summary = "Get all cards by refreshment stage"
    )
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<RefreshmentPlanDto> getByStage(@RequestParam RefreshmentStage stage, @PathVariable Long libraryId) {
        return refreshmentPlanService.retrieveByStage(stage, libraryId).stream()
                .map(refreshmentPlanMapper::toDto)
                .toList();
    }

    @GetMapping("/pending")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RefreshmentPlanDto> getPending(@PathVariable Long libraryId) {
        return refreshmentPlanService.retrievePending(libraryId).stream()
                .map(refreshmentPlanMapper::toDto)
                .toList();
    }

}
