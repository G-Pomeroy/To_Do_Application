<%--
  Created by IntelliJ IDEA.
  User: Gregory Pomeroy
  Date: 2024-02-14
  Time: 4:18 p.m.
--%>

<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.Task" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskStatus" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskDAO" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.TaskDatabase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String taskId = request.getParameter("id");
    TaskDAO taskDAO = new TaskDatabase();
    Task task = taskDAO.getTaskById(Integer.parseInt(taskId));
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify a Task</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/layout.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/typography.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/colors.css">
</head>
<body>

<div class="mainTitle">
    <h1>Modify an Existing Task</h1>
</div>

<div class="formCont">
    <div class="form">
        <form action="/WEBD3102_Assignment1_GregPomeroy-1.0-SNAPSHOT/modify-todo" method="post">
            <label for="taskName">Task Name:</label>
            <input type="text" id="taskName" name="taskName" value="<%= task.getTaskName() %>"><br>
            <br>
            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate" value="<%= task.getDueDate() %>"><br>
            <br>
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="TO_BE_COMPLETED" <%= task.getStatus() == TaskStatus.TO_BE_COMPLETED ? "selected" : "" %>>To Be Completed</option>
                <option value="IN_PROGRESS" <%= task.getStatus() == TaskStatus.IN_PROGRESS ? "selected" : "" %>>In Progress</option>
                <option value="COMPLETED" <%= task.getStatus() == TaskStatus.COMPLETED ? "selected" : "" %>>Completed</option>
            </select>
            <br><br>
            <input type="hidden" name="taskId" value="<%= taskId %>">
            <button type="submit">Update Task</button>
        </form>
    </div>
</div>

</body>
</html>