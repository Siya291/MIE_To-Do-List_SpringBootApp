package org.studentfirstapp.mie_todolist_springbootapp.dto;

import org.studentfirstapp.mie_todolist_springbootapp.enums.TaskCategoryEnum;

import java.sql.Timestamp;

public record TaskResponseDto(
        Long id,
        String taskName,
        TaskCategoryEnum taskCategoryEnum,
        String taskDescription,
        Timestamp taskDueDate,
        int taskPriority,
        boolean completed
        ) {
}
