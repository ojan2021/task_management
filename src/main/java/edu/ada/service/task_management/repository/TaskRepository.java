package edu.ada.service.task_management.repository;

import edu.ada.service.task_management.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByTitle(String title);
    Optional<TaskEntity> findById(Long id);

    @Modifying
    @Transactional
    @Query("update TaskEntity t set t.assigned_to = :username where t.id=:task_id")
    void assignTask(String username, Long task_id);


//    @Query(value = "insert into tasks(title, description, start_date, end_date, priority, task_status)\n" +
//            " VALUES (:title,:description,:start_date,:end_date,:priority,:task_status)",nativeQuery = true)
//    void createTask(@Param(value = "title") String title,
//                    @Param(value = "description") String description,
//                    @Param(value = "start_date") String start_date,
//                    @Param(value = "end_date") String end_date,
//                    @Param(value = "priority") String priority,
//                    @Param(value = "task_status") String task_status);
    
}
