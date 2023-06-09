package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.model.Module;
import by.bsu.courseproject.service.CardService;
import by.bsu.courseproject.web.dto.CardDto;
import by.bsu.courseproject.web.dto.group.OnCreate;
import by.bsu.courseproject.web.dto.group.OnTag;
import by.bsu.courseproject.web.dto.mapper.CardMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}/modules/{moduleId}/cards")
@SecurityRequirement(name = "Bearer Authentication")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;


    @Operation(
            summary = "Get card by id"
    )
    @GetMapping("/{cardId}")
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasModule(#libraryId,#moduleId)
            && @securityExpressions.hasCard(#moduleId,#cardId)
            """)
    public CardDto getById(@PathVariable Long libraryId,
                           @PathVariable Long moduleId,
                           @PathVariable Long cardId) {
        Card retrievedCard = cardService.retrieveById(cardId);
        return cardMapper.toDto(retrievedCard);
    }


    @Operation(
            summary = "Get all cards in module"
    )
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasModule(#libraryId,#moduleId)
            """)
    public List<CardDto> getByModuleId(@PathVariable Long libraryId, @PathVariable Long moduleId) {
        return cardService.retrieveByModuleId(moduleId).stream()
                .map(cardMapper::toDto)
                .toList();
    }

    //TODO
    @Operation(
            summary = "Add card to module"
    )
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasModule(#libraryId,#moduleId)
            """)
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


    @Operation(
            summary = "Delete card from module"
    )
    @DeleteMapping("/{cardId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PreAuthorize("""
            @securityExpressions.hasLibrary(#libraryId)
            && @securityExpressions.hasModule(#libraryId,#moduleId)
            && @securityExpressions.hasCard(#moduleId,#cardId)
            """)
    public void delete(@PathVariable Long libraryId,
                       @PathVariable Long moduleId,
                       @PathVariable Long cardId) {
        cardService.delete(cardId);
    }

}
