package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.AuthEntity;
import by.bsu.courseproject.web.dto.AuthEntityDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthEntityMapper {

    AuthEntity toEntity(AuthEntityDto dto);

    AuthEntityDto toDto(AuthEntity entity);

}
