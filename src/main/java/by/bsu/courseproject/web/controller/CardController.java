package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")//todo add context-path
public class CardController {

    private final CardService cardService;

    @GetMapping("/{cardId}")
    public Card get(@PathVariable Long cardId){ //todo return dto
        return cardService.retrieve(cardId); //todo map to dto
    }


}
