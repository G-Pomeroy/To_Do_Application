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


@WebServlet(name = "deleteTaskServlet", value = "/delete-task")
public class DeleteTask extends HttpServlet {
    private TaskDAO taskDAO;

    public DeleteTask() {
        this.taskDAO = new TaskDatabase();
    }

    public DeleteTask(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int taskId = Integer.parseInt(request.getParameter("id"));

        taskDAO.deleteTask(taskId);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Task deleted successfully");
    }
}