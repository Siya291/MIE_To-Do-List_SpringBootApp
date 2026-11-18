package org.taskapp.mie_todolist_springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskapp.mie_todolist_springbootapp.entity.TaskEntity;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    boolean existsByKeyword(String keyword);

    boolean existsByKeywordAndId(String keyword, Long id);

    Optional<TaskEntity> findByKeyword(String keyword);
}
