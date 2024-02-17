package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database;

import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.Task;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskDAO;
import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.model.TaskStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.DBConnect.getConnection;

public class TaskDatabase implements TaskDAO {

private static final String SQL_SELECT = "SELECT id, task_name, due_date, status FROM tasks";

private static final String SQL_SELECT_ONE = "SELECT id, task_name, due_date, status FROM tasks WHERE id = ?";

private static final String SQL_INSERT = "INSERT INTO tasks(task_name, due_date, status) VALUES (?,?,?)";

private static final String SQL_UPDATE = "UPDATE tasks SET task_name = ?, due_date = ?, status = ? WHERE id = ?";

private static final String SQL_DELETE = "DELETE FROM tasks WHERE id = ?";


    @Override
    public boolean addTask(Task task) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setDate(2, task.getDueDate());
            preparedStatement.setString(3, task.getStatus().toString());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            System.out.println("Error adding task: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }
    }

    @Override
    public Task getTaskById(int taskId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Task task = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT_ONE);
            preparedStatement.setInt(1, taskId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                task = new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("task_name"),
                        resultSet.getDate("due_date"),
                        TaskStatus.valueOf(resultSet.getString("status").toUpperCase())
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error retrieving task: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return task;
    }

    @Override
    public List<Task> getAllTasks() {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<>();

        try{
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();



            while(resultSet.next()){
                String statusString = resultSet.getString("status");
                TaskStatus status = TaskStatus.valueOf(statusString.toUpperCase());
                tasks.add(new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("task_name"),
                        resultSet.getDate("due_date"),
                        status
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return tasks;
    }




    @Override
    public boolean updateTask(Task task) {
        boolean rowUpdated = false;

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setDate(2, task.getDueDate());
            preparedStatement.setString(3, task.getStatus().toString());
            preparedStatement.setInt(4, task.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException ex){
            System.out.println("Error updating task: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return rowUpdated;
    }

    @Override
    public void deleteTask(int taskId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, taskId);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error deleting task: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
