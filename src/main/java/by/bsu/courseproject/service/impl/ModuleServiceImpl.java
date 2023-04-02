package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.model.User;
import by.bsu.courseproject.persistence.repository.ModuleRepository;
import by.bsu.courseproject.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import by.bsu.courseproject.model.Module;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    @Transactional
    public Module create(Module module) {
        Module moduleToCreate = Module.builder()
                .library(Library.builder()
                        .id(module.getLibrary().getId())
                        .user(User.builder()
                                .id(module.getLibrary().getUser().getId())
                                .build())
                        .build())
                .description(module.getDescription())
                .name(module.getName())
                .tags(module.getTags())
                .build();
        moduleRepository.create(moduleToCreate);
        return moduleToCreate;
    }

}
