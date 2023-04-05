package by.bsu.courseproject.web.dto.mapper;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ModuleMapper.class})
public interface CardMapper {

    Card toModel(CardDto dto);

    CardDto toDto(Card model);

}
