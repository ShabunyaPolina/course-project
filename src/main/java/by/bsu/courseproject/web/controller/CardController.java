package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.service.CardService;
import by.bsu.courseproject.web.dto.CardDto;
import by.bsu.courseproject.web.dto.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/libraries/{libraryId}/modules/{moduleId}/cards")
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

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody CardDto cardDto) {
        cardService.create(cardMapper.toModel(cardDto));
    }

    @DeleteMapping("/{cardId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long cardId) {
        cardService.delete(cardId);
    }
}
