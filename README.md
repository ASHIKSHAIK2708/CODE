To-Do List Application

A simple command-line To-Do List application written in Java. The application allows users to create, manage, and track tasks with the following features:

Add tasks with a title, description, and due date.
Mark tasks as complete.
View all tasks (with status and details).
Remove tasks from the list.
Features
Add Task
Users can create new tasks by providing a title, description, and due date.

Mark Task as Complete
Mark a task as complete once it is finished. This changes its status to "Complete."

View Tasks
Displays a list of all tasks with their details:

Index
Title
Description
Due Date
Status (Complete/Incomplete)
Remove Task
Remove a task from the list by selecting its index.

How to Run
Prerequisites:

Java Development Kit (JDK) installed (version 8 or higher)
A terminal or command prompt to run the application
Steps:

Clone this repository:
bash
Copy code
git clone https://github.com/your-username/todo-list-java.git
Navigate to the project directory:
bash
Copy code
cd todo-list-java
Compile the Java files:
bash
Copy code
javac ToDoList.java
Run the application:
bash
Copy code
java ToDoList
Code Structure
Task.java
The Task class represents a task with attributes: title, description, due date, and completion status. It includes getter methods and a method to mark the task as complete.

ToDoList.java
The ToDoList class manages a list of tasks using an ArrayList and handles user interaction through a menu. It allows users to add, view, complete, and remove tasks.

Example Usage
mathematica
Copy code
Welcome to the ToDo List Application!

===== To-Do List Menu =====
1. Add Task
2. Mark Task as Complete
3. View Tasks
4. Remove Task
5. Exit
Enter your choice: 1

===== Add Task =====
Enter task title: Complete Java project
Enter task description: Finish the command-line To-Do list application
Enter due date: 2024-10-31
Task added successfully!

===== To-Do List Menu =====
1. Add Task
2. Mark Task as Complete
3. View Tasks
4. Remove Task
5. Exit
Contributions
Feel free to submit a pull request or open an issue if you would like to contribute or report bugs.

License
This project is open-source and available under the MIT License.

