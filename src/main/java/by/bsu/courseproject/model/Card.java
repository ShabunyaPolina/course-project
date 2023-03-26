package by.bsu.courseproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;
    private Module module;
    private Boolean isMemorised;
    private String term;
    private String description;

}
