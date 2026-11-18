package org.studentfirstapp.mie_todolist_springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studentfirstapp.mie_todolist_springbootapp.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
