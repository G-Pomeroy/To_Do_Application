### To Do Web Application

## 1. Introduction
This is a web application that assists in tracking tasks and offering tools to manage them. This document outlines the architecture, components, and design of the application as well as how the application interacts with the user and database. 

## 2. Purpose
The primary purpose of this document is to provide a comprehensive overview of the design aspects of the task management application. It serves as a guide for developers and designers involved in deploying or utilizing the application, offering a clear understanding of the system's architecture, design principles, and implementation details.

# 2.1. Scope
Within this document, you will find an outline of the structure of the architecture of the web application, details of the design of the components featured in this project, and a brief highlight of the user interface. 

# 2.2. Audience
This document is intended for developers, designers, and any audiences that wish to understand the deployment and development of this project. It provides insight into the direction of the overall design to help the audiences mentioned above understand the direction of the project. 

## 3. System Overview
The requirements for this project were to use the following technology stack: JSP, Servlets, JDBC, and a MySQL server. Combining this technology, a front-end webpage was created with JSP and Servlets, that reach out to a server (JDBC and MySQL) to store, modify, and retrieve information.

# 3.1 Architecture
This application utilizes a Model-View-Controller (MVC) Architecture to ensure easier management and clearer design flow.

The Model Layer: 
This layer houses the business logic featured in the application. This includes classes such as Task, TaskDAO (Data Access Object), and TaskDatabase, which handle tasks' data management and manipulation.

The View Layer: 
This layer includes all user facing JSP (JavaServer Pages) and the interface in which the user interacts with the application. This includes JSP files like index.jsp, taskForm.jsp, taskModify.jsp, etc., which present data to users and handle user interactions.

The Controller Layer:
Acts as a bridge between the Model and View layers. This includes servlets such as ListTask, AddTask, UpdateTask, and DeleteTask, which receive user requests, interact with the Model layer to process data, and display appropriate JSP pages from the View layer.

DAO (Data Access Object) Layer: 
Handles interactions with the database. This includes classes like TaskDAO and TaskDatabase, which contain methods for CRUD (Create, Read, Update, Delete) operations on tasks.

Database: 
Outside of the MVC model, the application also makes use of a MySQL database that records, modifies, and retrieves task data from the user when the form has been submitted. It features a relational database to house the various data types.

UI / Front-End:
Consists of HTML, CSS, and JavaScript files for creating the user interface. JSP files are used for dynamic content generation on the server-side, while CSS is used for styling and JavaScript for client-side interactions.

Servlet Container (GlassFish 7.0.91):
Provides the initial environment for running servlets and handling HTTP requests/responses.

# 3.2. Dependencies 
For this project, the dependencies required are as follows:
•	MySQL J-Connector 8.3.0.
•	Jakarta EE
•	Maven
•	SDK 18

## 4. Usage Guide
The following sections will provide an overview of how to interact with the application and how to utilize the task management functionality.
4.1. User Interface Overview
Upon accessing the web application, you will be provided with an up-to-date list of current tasks that have been logged into the system. At first the table will be blank, so you will only see the blank cells to begin with. 
Below the table you can see the button to “Add Task” clicking this button will bring you to the “Add a New Task” page where you can enter a new task into the application. The fields to fill out before you can submit the task are:

•	Task name or description
•	Due Date of the task
•	Status of the task in either:
o	To Be Completed
o	In Progress
o	Completed

Once these fields have been filled out, you will be able to submit the task into the database, and you will be brought back to the main webpage where you can see your newly entered task. 
Once a new task has been entered, you will have the option of clicking two additional buttons on the end of the task “Modify” and “Delete”. Clicking “Modify” will bring you to a similar page as the “Add a New Task” page, but the details will already be filled out for you of the information of that task when it was newly created, or last updated. Clicking “Delete” will prompt you if you would like to delete the task in the form of a pop-up window. Clicking “Yes” will delete the task and clicking “No” will bring you back to the main page

# 4.2. Application Flow Figure
![image](https://github.com/G-Pomeroy/WEBD3102_Assignment1_ToDoApp/assets/117761897/b9afab08-1fce-4861-8f3c-52b265c221c1)

## 5. API Documentation
This section will describe the endpoints that are in the application and what each point indicates for the flow of the application.

# 5.1 Endpoints

POST “/add-todo”:
•	Description: Endpoint for adding a new task to the application.
•	Method: POST
•	URL: /add-todo

POST “/delete-task”
•	Description: Endpoint for deleting entry in the application.
•	Method: POST
•	URL: /delete-task

POST “modify-task”
•	Description: Endpoint for initiating modification of existing entry.
•	Method: POST
•	URL: /modify-task

GET “/list-tasks”
•	Description: Endpoint for retrieving all currently valid tasks that are in the database.
•	Method: GET
•	URL: /list-tasks

## 6. Database Schema
The following section will discuss the design of the database and how the data is collected, stored, and related to the overall design of the web application. 

# 6.1 Entity-Relationship Diagram
The database consists of one table: “Tasks” that has four tables (id, task_name, due_date, and status). See below for a description of each table and the data type it uses.

# 6.2 Table Definitions
The following definitions and data types of the database table are as follows:

“id”: int, Primary Key, Auto Increment.
•	This field is automatically assigned whenever a new task is created. This id is also used when modifying a task by using the id as a variable within the URL to ensure that the same entry is updated.

“task_name”: Varchar (255), required.
•	This field is the name or descriptor of the task and is used to quickly remember the task that this entry was created for.

“due_date”: Date, required.
•	This field is the due date that the task is intended to be completed for, or the date that the user wishes to be reminded of if the task is being used as a reminder instead of a task/job.

“status”: Enum (‘To Be Completed’, ’In Progress’, ’Completed’), required.
•	This is the status of the task in case the task is anticipated to take longer, or if the user would like to mark it in various stages of completion. 

