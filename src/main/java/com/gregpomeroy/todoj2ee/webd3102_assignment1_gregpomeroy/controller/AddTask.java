package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.controller;

import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.TaskDatabase;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.Task;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskDAO;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "addTodoServlet", value = "/add-todo")
public class AddTask extends HttpServlet {
    private TaskDAO taskDAO;

    public AddTask() {
        this.taskDAO = new TaskDatabase();
    }

    public AddTask(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskName = request.getParameter("taskName");
        String dueDateString = request.getParameter("dueDate");
        Date dueDate = Date.valueOf(dueDateString);
        String statusString = request.getParameter("status");

        TaskStatus status = TaskStatus.valueOf(statusString.toUpperCase());

        Task task = new Task(taskName, dueDate, status);

        boolean success = taskDAO.addTask(task);

        if (success) {
            response.sendRedirect("view/index.jsp");
        } else {
            response.getWriter().println("Failed to add task. Please try again.");
        }
    }
}

