package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model;
import java.util.List;

    public interface TaskDAO {
        boolean addTask(Task task);
        Task getTaskById(int taskId);
        List<Task> getAllTasks();
        boolean updateTask(Task task);
        void deleteTask(int taskId);
    }

