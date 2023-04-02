package by.bsu.courseproject.web.dto;

public record CardDto(
        //todo constraints

        Long id,
        ModuleDto module,
        String term,
        String definition,
        Boolean isMemorised

) {
}
