package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.persistence.repository.ModuleRepository;
import by.bsu.courseproject.service.ModuleService;
import by.bsu.courseproject.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import by.bsu.courseproject.model.Module;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final TagService tagService;

    @Override
    @Transactional
    public void create(Module module) {
        moduleRepository.create(module);
        module.getTags().forEach(
                tag -> {
                    tagService.createIfNotExists(tag);
                    tagService.addTagToModule(tag.getId(), module.getId());
                }
        );
    }

}
