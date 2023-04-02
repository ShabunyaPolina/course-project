package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.Tag;
import by.bsu.courseproject.web.dto.TagDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagListMapper {

    List<Tag> toModel(List<TagDto> dto);

    List<TagDto> toDto(List<Tag> model);

}
