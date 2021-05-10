package edu.ada.service.task_management.repository;

import edu.ada.service.task_management.model.entity.TaskEntity;
import edu.ada.service.task_management.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByTitle(String title);

}
