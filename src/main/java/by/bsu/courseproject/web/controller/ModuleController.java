package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.model.Module;
import by.bsu.courseproject.service.ModuleService;
import by.bsu.courseproject.service.RefreshmentPlanService;
import by.bsu.courseproject.web.dto.ModuleDto;
import by.bsu.courseproject.web.dto.group.OnCreate;
import by.bsu.courseproject.web.dto.mapper.ModuleMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}/modules")
@SecurityRequirement(name = "Bearer Authentication")
public class ModuleController {

    private final ModuleService moduleService;
    private final RefreshmentPlanService refreshmentPlanService;
    private final ModuleMapper moduleMapper;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("@securityExpressions.hasLibrary(#libraryId)")
    public ModuleDto create(
            @Validated(OnCreate.class) @RequestBody ModuleDto moduleDto,
            @PathVariable Long libraryId
    ) {
        Module module = moduleMapper.toModel(moduleDto);
        module.setLibrary(Library.builder()
                .id(libraryId)
                .build());
        moduleService.create(module);
        return moduleMapper.toDto(module);
    }

    @PatchMapping("/{moduleId}")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasModule(#libraryId,#moduleId)
            """)
    public void considerRefreshment(
            @RequestParam Boolean needsRefreshment,
            @PathVariable Long libraryId, @PathVariable Long moduleId) {
        refreshmentPlanService.considerRefreshment(moduleId, needsRefreshment);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            """)
    public List<ModuleDto> getByLibraryId(@PathVariable Long libraryId) {
        return moduleService.retrieveByLibraryId(libraryId).stream()
                .map(moduleMapper::toDto)
                .toList();
    }

}
