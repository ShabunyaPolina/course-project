package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.model.exception.ResourceNotFoundException;
import by.bsu.courseproject.persistence.repository.LibraryRepository;
import by.bsu.courseproject.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Override
    @Transactional(readOnly = true)
    public Library retrieveById(Long libraryId) {
        return libraryRepository.findById(libraryId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Library with id " + libraryId + " not found")
                );
    }

    @Override
    @Transactional
    public void create(Library library) {
        libraryRepository.create(library);
    }

}
