package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.controller;

import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.TaskDatabase;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.Task;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "listAllTasks", value = "/list-tasks")
public class ListTask extends HttpServlet {

    private TaskDAO taskDAO;

    public ListTask() {
        this.taskDAO = new TaskDatabase();
    }

    public ListTask(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = taskDAO.getAllTasks();

        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("view/index.jsp").forward(request, response);
    }
}
