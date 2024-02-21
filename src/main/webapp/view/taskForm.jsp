<%--
  Created by IntelliJ IDEA.
  User: Gregory Pomeroy
  Date: 2024-02-14
  Time: 4:18 p.m.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add a New Task</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/layout.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/typography.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/colors.css">
</head>
<body>

<div class="mainTitle">
<h1>Add a New Task</h1>
</div>

<div class="formCont">
<div class="form">
    <form action="/WEBD3102_Assignment1_GregPomeroy-1.0-SNAPSHOT/add-todo" method="post">
        <label for="taskName">Task Name:</label>
        <input type="text" id="taskName" name="taskName" required><br>
        <br>
        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required><br>
        <br>
        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="TO_BE_COMPLETED">To Be Completed</option>
            <option value="IN_PROGRESS">In Process</option>
            <option value="COMPLETED">Completed</option>
        </select>
        <br><br>

        <button type="submit">Add Task</button>
    </form>
</div>
</div>

</body>
</html>
