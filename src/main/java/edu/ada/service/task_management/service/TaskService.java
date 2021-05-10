package edu.ada.service.task_management.service;

import edu.ada.service.task_management.model.entity.TaskEntity;

public interface TaskService {
    TaskEntity searchByTitle(String title);
    TaskEntity searchById(Long id);
    void createTask();
    void deleteTask();
    void editTask();
    void assignTask();

}
