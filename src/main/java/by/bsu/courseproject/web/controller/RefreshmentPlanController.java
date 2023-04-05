package by.bsu.courseproject.web.controller;

import by.bsu.courseproject.model.RefreshmentPlan;
import by.bsu.courseproject.model.RefreshmentStage;
import by.bsu.courseproject.service.RefreshmentPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/libraries/{libraryId}/refreshment-plans")
public class RefreshmentPlanController {

    private final RefreshmentPlanService refreshmentPlanService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    private List<RefreshmentPlan> getByStage(@RequestParam RefreshmentStage stage) { //todo dto
        return refreshmentPlanService.retrieveByStage(stage);
    }

}