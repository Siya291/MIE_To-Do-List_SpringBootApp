package org.taskapp.mie_todolist_springbootapp.dto;

import org.taskapp.mie_todolist_springbootapp.enums.TaskCategoryEnum;

import java.sql.Timestamp;

public record TaskResponseDto(
        Long id,
        String taskName,
        String keyword,
        TaskCategoryEnum taskCategoryEnum,
        String taskDescription,
        Timestamp taskDueDate,
        int taskPriority,
        boolean completed
        ) {
}
