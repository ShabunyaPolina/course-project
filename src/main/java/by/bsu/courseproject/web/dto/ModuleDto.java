package by.bsu.courseproject.web.dto;

import java.util.List;

public record ModuleDto(
        //todo constraints

        Long id,
        LibraryDto library,
        String name,
        String description,
        List<String> tags

) {
}
