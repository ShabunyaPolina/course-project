package by.bsu.courseproject.service.impl;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.model.exception.ResourceNotFoundException;
import by.bsu.courseproject.persistence.repository.CardRepository;
import by.bsu.courseproject.service.CardService;
import by.bsu.courseproject.service.RefreshmentPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final RefreshmentPlanService refreshmentPlanService;

    @Override
    @Transactional(readOnly = true)
    public Card retrieveById(Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Card with id " + cardId + " not found")
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Card> retrieveByModuleId(Long moduleId) {
        return cardRepository.findByModuleId(moduleId);
    }

    @Override
    @Transactional
    public void create(Card card) {
        cardRepository.create(card);
    }

    @Override
    @Transactional
    public void delete(Long cardId) {
        cardRepository.delete(cardId);
    }

    @Override
    @Transactional
    public void considerRefreshment(Long moduleId, Boolean needsRefreshment) {
        List<Card> cards = retrieveByModuleId(moduleId);
        if (needsRefreshment) {
            //todo
        } else {
            //todo
        }
    }
}
