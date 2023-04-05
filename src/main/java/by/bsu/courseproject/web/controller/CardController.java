package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.model.Module;
import by.bsu.courseproject.service.CardService;
import by.bsu.courseproject.web.dto.CardDto;
import by.bsu.courseproject.web.dto.group.OnCreate;
import by.bsu.courseproject.web.dto.group.OnTag;
import by.bsu.courseproject.web.dto.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}/modules/{moduleId}/cards")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping("/{cardId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CardDto getById(@PathVariable Long cardId) {
        Card retrievedCard = cardService.retrieveById(cardId);
        return cardMapper.toDto(retrievedCard);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<CardDto> getByModuleId(@PathVariable Long moduleId) {
        return cardService.retrieveByModuleId(moduleId).stream()
                .map(cardMapper::toDto)
                .toList();
    }

    //TODO
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CardDto create(
            @Validated({OnCreate.class, OnTag.class}) @RequestBody CardDto cardDto,
            @PathVariable Long libraryId,
            @PathVariable Long moduleId
    ) {
        Card card = cardMapper.toModel(cardDto);
        card.setModule(Module.builder()
                .id(moduleId)
                .build()
        );
        cardService.create(card);
        return cardMapper.toDto(card);
    }

    @DeleteMapping("/{cardId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long cardId) {
        cardService.delete(cardId);
    }

}
