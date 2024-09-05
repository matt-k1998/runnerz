package com.example.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    public Run {
        if(!completedOn.isAfter(startedOn)) {
            try {
                throw new IllegalAccessException("Completed on must be after Started on");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
