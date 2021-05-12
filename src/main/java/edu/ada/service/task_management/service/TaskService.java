package edu.ada.service.task_management.service;

import edu.ada.service.task_management.model.entity.TaskEntity;

import java.util.Optional;

public interface TaskService {
    Optional<TaskEntity> searchByTitle(String title);
    Optional<TaskEntity> searchById(Long id);
    void createTask(String title, String description,
                    String start_date, String end_date,
                    String priority, String task_status, String assigned_to);
    void deleteTask(Long id);
    void assignTask(String username, Long task_id);
    void scheduleTask(Long task_id, String start_date, String end_date);
    void updateTaskStatus(Long task_id, String task_status);
//    void editProfile(String firstname, String lastname, String email, String birthday);

}
