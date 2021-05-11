package edu.ada.service.task_management.service.impl;

import edu.ada.service.task_management.model.entity.TaskEntity;
import edu.ada.service.task_management.service.TaskService;
import org.springframework.stereotype.Service;

@Service(value = "TaskServiceImpl")
public class TaskServiceImpl implements TaskService {

    @Override
    public TaskEntity searchByTitle(String title) {
        return null;
    }

    @Override
    public TaskEntity searchById(Long id) {
        return null;
    }

    @Override
    public void createTask() {

    }

    @Override
    public void deleteTask() {

    }

    @Override
    public void editTask() {

    }

    @Override
    public void assignTask() {

    }
}
