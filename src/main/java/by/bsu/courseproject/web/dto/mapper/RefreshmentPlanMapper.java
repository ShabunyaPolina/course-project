package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.web.dto.RefreshmentPlanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LibraryMapper.class})
public interface RefreshmentPlanMapper {

    RefreshmentPlan toModel(RefreshmentPlanDto dto);

    RefreshmentPlanDto toDto(RefreshmentPlan model);

}
