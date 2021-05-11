package edu.ada.service.task_management.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(	name = "tasks",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title")
        })
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String title;

    @NotBlank
    @Size(max = 250)
    private String description;

    @NotBlank
    @Size(max = 40)
    private String start_date;

    @NotBlank
    @Size(max = 40)
    private String end_date;

    @NotBlank
    @Size(max = 20)
    private String priority;

    @NotBlank
    @Size(max = 20)
    private String task_status;

    public TaskEntity(){
    }

    public TaskEntity(String title, String description, String start_date, String end_date, String priority, String task_status) {
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.priority = priority;
        this.task_status = task_status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }
}
