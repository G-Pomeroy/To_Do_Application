<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.Task" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskDAO" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.TaskDatabase" %>
<%@ page import="com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.TaskHelper" %>

<%
    TaskDAO taskDAO = new TaskDatabase();
    List<Task> tasks = taskDAO.getAllTasks();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/layout.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/typography.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/styles/colors.css">
</head>
<body>
<h1 class="titleName">Task List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Task ID</th>
        <th>Task Name</th>
        <th>Due Date</th>
        <th>Status</th>
        <th>Delete</th>
        <th>Modify</th>
    </tr>
    </thead>
    <tbody>
    <% for (Task task : tasks) { %>
    <tr>
        <td><%= task.getId() %></td>
        <td><%= task.getTaskName() %></td>
        <td><%= task.getDueDate() %></td>
        <td><%=TaskHelper.formatStatus(task.getStatus().toString())%></td>
        <td><button onclick="deleteTask(<%= task.getId() %>)">Delete</button></td>
        <td><button onclick="location.href='${pageContext.request.contextPath}/view/taskModify.jsp?id=<%= task.getId() %>'" type="button">Modify</button></td>

    </tr>
    <% } %>
    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function deleteTask(taskId) {
        const confirmation = confirm("Are you sure you want to delete this task?");
        if(confirmation) {
            $.ajax({
                type: "POST",
                url: "delete-task",
                data: {id: taskId},
                success: function (response) {
                    console.log("Task deleted successfully");

                    //Update table to reflect changes
                    const rowToDelete = document.getElementById("taskRow_" + taskId);
                    if (rowToDelete) {
                        rowToDelete.parentNode.removeChild(rowToDelete);
                    }
                    location.reload();
                },
                error: function (xhr, status, error) {
                    console.error("Failed to delete task: " + error);
                }
            });
        } else {
            //Deletion was cancelled from alert box
        }
    }
</script>

<br><br>
<div class="buttonCont">
<button class="addButton" onclick="location.href='${pageContext.request.contextPath}/view/taskForm.jsp'">Add Task</button>
</div>
</body>
</html>