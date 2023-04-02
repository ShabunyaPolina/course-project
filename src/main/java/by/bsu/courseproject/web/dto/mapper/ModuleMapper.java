package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.web.dto.ModuleDto;
import by.bsu.courseproject.model.Module;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LibraryMapper.class})
public interface ModuleMapper {

    Module toModel(ModuleDto dto);

    ModuleDto toDto(Module model);

}
