package org.studentfirstapp.mie_todolist_springbootapp.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.studentfirstapp.mie_todolist_springbootapp.dto.TaskRequestDto;
import org.studentfirstapp.mie_todolist_springbootapp.dto.TaskResponseDto;
import org.studentfirstapp.mie_todolist_springbootapp.entity.TaskEntity;
import org.studentfirstapp.mie_todolist_springbootapp.exception.DuplicateResourceException;
import org.studentfirstapp.mie_todolist_springbootapp.exception.ResourceNotFoundException;
import org.studentfirstapp.mie_todolist_springbootapp.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskResponseDto createTask(TaskRequestDto request) {
        if (taskRepository.existsByKeyword(request.keyword())) {
            throw new DuplicateResourceException("A Task with this keyword already exists");
        }

        TaskEntity tasks = new TaskEntity();
        tasks.setTaskName(request.taskName());
        tasks.setKeyword(request.keyword());
        tasks.setTaskCategoryEnum(request.taskCategoryEnum());
        tasks.setTaskDescription(request.taskDescription());
        tasks.setTaskDueDate(request.taskDueDate());
        tasks.setTaskPriority(request.taskPriority());
        tasks.setCompleted(request.completed());

        TaskEntity savedTasks = taskRepository.save(tasks);

        return mapToResponse(savedTasks);
    }

    @Transactional(readOnly = true)
    public List<TaskResponseDto> getAllTasks() {

        return taskRepository.findAll(). stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskResponseDto getTaskById(Long id) {
        TaskEntity task = findTaskOrThrow(id);

        return mapToResponse(task);
    }

    @Transactional
    public TaskResponseDto updateStudent(Long id, TaskRequestDto request) {
        TaskEntity task = findTaskOrThrow(id);
        boolean keywordAlreadyUsed = taskRepository.existsByKeywordAndId(request.keyword(), id);

        if (keywordAlreadyUsed) {
            throw new DuplicateResourceException("Keyword Already Used");
        }
        task.setTaskName(request.taskName());
        task.setKeyword(request.keyword());
        task.setTaskCategoryEnum(request.taskCategoryEnum());
        task.setTaskDescription(request.taskDescription());
        task.setTaskDueDate(request.taskDueDate());
        task.setTaskPriority(request.taskPriority());
        task.setCompleted(request.completed());

        TaskEntity updatedTask = taskRepository.save(task);

        return mapToResponse(updatedTask);

    }

    private TaskEntity findTaskOrThrow(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));
    }

    @Transactional
    public void deleteTask(Long id) {
        TaskEntity task = findTaskOrThrow(id);
        taskRepository.delete(task);
    }

    private TaskResponseDto mapToResponse(TaskEntity tasks) {
        return new TaskResponseDto(tasks.getId(),
                tasks.getTaskName(),
                tasks.getKeyword(),
                tasks.getTaskCategoryEnum(),
                tasks.getTaskDescription(),
                tasks.getTaskDueDate(),
                tasks.getTaskPriority(),
                tasks.isCompleted());
    }
}
