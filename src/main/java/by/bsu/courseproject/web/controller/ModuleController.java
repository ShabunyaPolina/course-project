package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.model.Module;
import by.bsu.courseproject.service.ModuleService;
import by.bsu.courseproject.service.RefreshmentPlanService;
import by.bsu.courseproject.web.dto.ModuleDto;
import by.bsu.courseproject.web.dto.group.OnCreate;
import by.bsu.courseproject.web.dto.mapper.ModuleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}/modules")
public class ModuleController {

    private final ModuleService moduleService;
    private final RefreshmentPlanService refreshmentPlanService;
    private final ModuleMapper moduleMapper;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    private ModuleDto create(
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
    private void considerRefreshment(
            @RequestParam Boolean needsRefreshment,
            @PathVariable Long libraryId, @PathVariable Long moduleId) {
        refreshmentPlanService.considerRefreshment(moduleId, needsRefreshment);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    private List<ModuleDto> getByLibraryId(@PathVariable Long libraryId) {
        return moduleService.retrieveByLibraryId(libraryId).stream()
                .map(moduleMapper::toDto)
                .toList();
    }

}
