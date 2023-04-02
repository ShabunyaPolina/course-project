package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.Tag;
import by.bsu.courseproject.web.dto.TagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toModel(TagDto dto);

    TagDto toDto(Tag model);

}
