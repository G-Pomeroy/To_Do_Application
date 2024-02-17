package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model;

import java.sql.Date;

public class Task {
    private int id;
    private String taskName;
    private Date dueDate;
    private TaskStatus status;

    public Task() {}

    public Task(String taskName, Date dueDate, TaskStatus status) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(int id, String taskName, Date dueDate, TaskStatus status) {
        this.id = id;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
    }

    //Getters and Setters
    //region
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    //endregion


    //ToString Method for quick printing
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                '}';
    }
}