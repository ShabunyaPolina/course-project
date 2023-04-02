package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.Tag;
import by.bsu.courseproject.persistence.repository.TagRepository;
import by.bsu.courseproject.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    @Transactional
    public void addTagToModule(Long tagId, Long moduleId) {
        tagRepository.addTagToModule(tagId, moduleId);
    }

    @Override
    @Transactional
    public void createIfNotExists(Tag tag) {
        Optional<Tag> tagOptional = tagRepository.findByValue(tag.getValue());
        if (tagOptional.isPresent()) {
            Tag tagFromRepository = tagOptional.get();
            tag.setId(tagFromRepository.getId());
        } else {
            create(tag);
        }
    }

    @Override
    @Transactional
    public void create(Tag tag) {
        tagRepository.create(tag);
    }

}
