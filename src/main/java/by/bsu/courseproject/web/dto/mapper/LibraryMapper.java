package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.web.dto.LibraryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface LibraryMapper {

    Library toModel(LibraryDto dto);

    LibraryDto toDto(Library model);

}
