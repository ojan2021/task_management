package edu.ada.service.task_management.controller;

import edu.ada.service.task_management.model.entity.TaskEntity;
import org.springframework.http.ResponseEntity;

public interface TaskOperationsWS {
    ResponseEntity searchByTitle(String title);
    ResponseEntity searchById(Long id);
    ResponseEntity createTask(String title, String description,
                              String start_date, String end_date,
                              String priority, String task_status, String assigned_to);
    ResponseEntity deleteTask(Long id);
    ResponseEntity assignTask(String username, Long task_id);
    ResponseEntity scheduleTask(Long task_id, String start_date, String end_date);
    ResponseEntity updateTaskStatus(Long task_id, String task_status);
//    ResponseEntity editProfile(String firstname, String lastname, String email, String birthday);

}
