package by.bsu.courseproject.web.dto;

import lombok.Builder;

import java.util.Map;

@Builder
public record ExceptionDto(

        String message,
        Map<String,String> otherInfo

) {
}