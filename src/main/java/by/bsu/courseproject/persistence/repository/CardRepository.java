package by.bsu.courseproject.persistence.repository;

import by.bsu.courseproject.model.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CardRepository {

    Optional<Card> findById(Long cardId);

    List<Card> findByModuleId(Long moduleId);

    void create(Card card);

    void delete(Long cardId);

}
