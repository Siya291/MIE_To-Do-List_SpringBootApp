package org.studentfirstapp.mie_todolist_springbootapp.dto;

import jakarta.validation.constraints.*;
import org.studentfirstapp.mie_todolist_springbootapp.enums.TaskCategoryEnum;

import java.sql.Timestamp;

public record TaskRequestDto(
        @NotBlank(message = "Task name is required")
        @Size(max = 100, message = "Task name must not exceed 100 characters")
        String taskName,

        @NotBlank(message = "Category Type is required")
        @Size(max = 30, message = "Category type must not exceed 30 characters")
        TaskCategoryEnum taskCategoryEnum,

        @NotBlank(message = "Task description is required")
        @Size(max = 500, message = "Description must not exceed 500 characters")
        String taskDescription,

        @NotNull(message = "Due date is required")
        @FutureOrPresent(message = "Due date cannot be in the past")
        Timestamp taskDueDate,

        @Min(value = 1, message = "Priority must be at least 1")
        @Max(value = 5, message = "Priority cannot exceed 5")
        int taskPriority,

        boolean completed
        ) {
}
