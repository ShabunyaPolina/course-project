package by.bsu.courseproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    private Long id;
    private Library library;
    private String name;
    private String description;
    private List<String> tags;

}
