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
public class Card {

    private Long id;
    private Module module;
    private String term;
    private String definition;
    private Boolean isMemorised;
    private LocalDateTime refreshTime;
    private RefreshmentStage stage;

}
