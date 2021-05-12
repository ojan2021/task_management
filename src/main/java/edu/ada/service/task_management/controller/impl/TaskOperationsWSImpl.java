package edu.ada.service.task_management.controller.impl;

import edu.ada.service.task_management.controller.TaskOperationsWS;
import edu.ada.service.task_management.security.jwt.JwtUtils;
import edu.ada.service.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskOperationsWSImpl implements TaskOperationsWS {

    @Autowired
    @Qualifier(value = "TaskServiceImpl")
    TaskService taskService;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value = "/sbt",method = RequestMethod.GET)
    public ResponseEntity searchByTitle(@RequestHeader("title") String title) {
        return ResponseEntity.ok(taskService.searchByTitle(title));
    }

    @Override
    @RequestMapping(value = "/sbid",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity searchById(@RequestHeader("id") Long id) {
        return ResponseEntity.ok(taskService.searchById(id));
    }


    @Override
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createTask(@RequestHeader("title") String title,
                                     @RequestHeader("description") String description,
                                     @RequestHeader("start_date") String start_date,
                                     @RequestHeader("end_date") String end_date,
                                     @RequestHeader("priority") String priority,
                                     @RequestHeader("task_status") String task_status,
                                     @RequestHeader("assigned_to") String assigned_to) {
        taskService.createTask(title,description,start_date,end_date,priority,task_status,assigned_to);
        return new ResponseEntity<>("Created the task successfully", HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteTask(@RequestHeader("id") Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Deleted the task successfully", HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value = "/assign",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity assignTask(@RequestHeader("username") String username,
                                     @RequestHeader("task_id") Long task_id) {
        taskService.assignTask(username,task_id);
        return new ResponseEntity<>("Task " + task_id + " is assigned to " + username, HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value = "/schedule",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity scheduleTask(@RequestHeader("task_id") Long task_id,
                                       @RequestHeader("start_date") String start_date,
                                       @RequestHeader("end_date") String end_date) {
        taskService.scheduleTask(task_id,start_date,end_date);
        return new ResponseEntity<>("Task " + task_id + " is scheduled successfully", HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value = "/update_status",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity updateTaskStatus(@RequestHeader("task_id") Long task_id,
                                           @RequestHeader("task_status") String task_status) {
        taskService.updateTaskStatus(task_id,task_status);
        return new ResponseEntity<>("Changed Task " + task_id + "'s status to " + task_status, HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value = "/edit_profile",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity editProfile(@RequestHeader("firstname") String firstname,
                                      @RequestHeader("lastname") String lastname,
                                      @RequestHeader("email") String email,
                                      @RequestHeader("birthday") String birthday,
                                      @RequestHeader("Authorization") String auth) {
        auth = auth.substring(7);
        taskService.editProfile(firstname,lastname,email,birthday,jwtUtils.getUserNameFromJwtToken(auth));
        return new ResponseEntity<>("Edited the profile successfully", HttpStatus.ACCEPTED);
    }
}
