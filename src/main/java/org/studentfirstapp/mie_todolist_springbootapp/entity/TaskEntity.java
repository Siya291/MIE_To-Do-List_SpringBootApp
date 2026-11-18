package org.studentfirstapp.mie_todolist_springbootapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.studentfirstapp.mie_todolist_springbootapp.enums.TaskCategoryEnum;

import java.sql.Timestamp;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "Tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String taskName;

    @Column(name = "Keyword", nullable = false, unique = true)
    private String keyword;

    @Column(name = "Category", nullable = false)
    private TaskCategoryEnum taskCategoryEnum;

    @Column(name = "Description", nullable = false)
    private String taskDescription;

    @Column(name = "Due_Date", nullable = false)
    private Timestamp taskDueDate;

    @Column(name = "Priority", nullable = false)
    private int taskPriority;

    @Column(name = "IsCompleted", nullable = false)
    private boolean isCompleted;
}
