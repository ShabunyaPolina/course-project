package by.bsu.courseproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshmentPlan {

    private Long id;
    private Card card;
    private LocalDateTime refreshTime;
    private RefreshmentStage stage;

}
