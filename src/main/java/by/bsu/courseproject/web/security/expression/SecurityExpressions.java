package by.bsu.courseproject.web.security.expression;

import by.bsu.courseproject.model.Card;
import by.bsu.courseproject.model.Library;
import by.bsu.courseproject.model.Module;
import by.bsu.courseproject.service.CardService;
import by.bsu.courseproject.service.LibraryService;
import by.bsu.courseproject.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityExpressions {

    private final LibraryService libraryService;
    private final ModuleService moduleService;
    private final CardService cardService;

    public boolean hasLibrary(Long libraryId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Library library = libraryService.retrieveById(libraryId);
        return library.getUser().getEmail()
                .equals(authentication.getName());
    }

    public boolean hasModule(Long libraryId, Long moduleId) {
        Module module = moduleService.retrieveById(moduleId);
        return libraryId.equals(module.getLibrary().getId());
    }

    public boolean hasCard(Long moduleId, Long cardId) {
        Card card = cardService.retrieveById(cardId);
        return moduleId.equals(card.getModule().getId());
    }

    public boolean hasRefreshmentPlan(Long libraryId, Long refreshmentPlanId) {
        return true;//todo
    }
}
