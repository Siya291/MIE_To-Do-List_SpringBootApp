package org.studentfirstapp.mie_todolist_springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studentfirstapp.mie_todolist_springbootapp.entity.TaskEntity;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    boolean exixtsByKeyword(String keyword);

    boolean exixtsByKeywordAndId(String keyword, Long id);

    Optional<TaskEntity> findByKeyword(String keyword);
}
