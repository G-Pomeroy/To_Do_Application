<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.Task" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskDAO" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.TaskDatabase" %>

<%
    TaskDAO taskDAO = new TaskDatabase();
    List<Task> tasks = taskDAO.getAllTasks();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
</head>
<body>
<h1>Task List</h1>

<table border="1">
    <thead>
    <tr>
        <th>Task ID</th>
        <th>Task Name</th>
        <th>Due Date</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <% for (Task task : tasks) { %>
    <tr>
        <td><%= task.getId() %></td>
        <td><%= task.getTaskName() %></td>
        <td><%= task.getDueDate() %></td>
        <td><%= task.getStatus() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<br><br>
<a href="taskForm.jsp">Add Task</a>
<a href="taskModify.jsp">Modify Task</a>
<a href="taskDelete.jsp">Delete Task</a>

</body>
</html>