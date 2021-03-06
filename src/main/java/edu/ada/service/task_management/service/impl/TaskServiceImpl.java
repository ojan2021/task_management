package edu.ada.service.task_management.service.impl;

import edu.ada.service.task_management.model.entity.TaskEntity;
import edu.ada.service.task_management.repository.TaskRepository;
import edu.ada.service.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "TaskServiceImpl")
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Optional<TaskEntity> searchByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public Optional<TaskEntity> searchById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void createTask(String title, String description, String start_date, String end_date, String priority, String task_status, String assigned_to) {
//        taskRepository.createTask(title,description,start_date,end_date,priority,task_status);
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setStart_date(start_date);
        task.setEnd_date(end_date);
        task.setPriority(priority);
        task.setTask_status(task_status);
        task.setAssigned_to(assigned_to);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void assignTask(String username, Long task_id) {
        taskRepository.assignTask(username,task_id);
    }

    @Override
    public void scheduleTask(Long task_id, String start_date, String end_date) {
        taskRepository.scheduleTask(task_id,start_date,end_date);
    }

    @Override
    public void updateTaskStatus(Long task_id, String task_status) {
        taskRepository.updateTaskStatus(task_id,task_status);
    }

    @Override
    public void editProfile(String firstname, String lastname, String email, String birthday, String username) {
        taskRepository.editProfile(firstname,lastname,email,birthday,username);
    }
}
