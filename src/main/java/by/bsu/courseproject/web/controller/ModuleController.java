package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.model.User;
import by.bsu.courseproject.service.ModuleService;
import by.bsu.courseproject.web.dto.ModuleDto;
import by.bsu.courseproject.web.dto.mapper.ModuleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import by.bsu.courseproject.model.Module;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/libraries/{libraryId}/modules")
public class ModuleController {

    private final ModuleService moduleService;
    private final ModuleMapper moduleMapper;

    @PostMapping
    private ModuleDto create(@RequestBody ModuleDto moduleDto,
                             @PathVariable Long libraryId,
                             @PathVariable Long userId) {
        Module module = moduleMapper.toModel(moduleDto);
        module.setLibrary(Library.builder()
                .id(libraryId)
                .user(User.builder()
                        .id(userId)
                        .build())
                .build());
        Module createdModule = moduleService.create(module);
        return moduleMapper.toDto(createdModule);
    }

}
