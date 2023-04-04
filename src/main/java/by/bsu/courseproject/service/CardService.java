package by.bsu.courseproject.service;

import by.bsu.courseproject.model.Card;

import java.util.List;

public interface CardService {

    Card retrieveById(Long cardId);

    List<Card> retrieveByModuleId(Long moduleId);

    void create(Card card);

    void delete(Long cardId);

}
