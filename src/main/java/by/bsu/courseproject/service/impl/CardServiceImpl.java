package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.persistence.repository.CardRepository;
import by.bsu.courseproject.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    @Transactional
    public Card retrieve(Long cardId) {
        return cardRepository.findById(cardId).get();//todo throw exception
    }

}
