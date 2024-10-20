import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to the To-Do List Application!");
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsComplete();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the To-Do List App!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Displays the menu options
    private static void displayMenu() {
        System.out.println("\n===== To-Do List Menu =====");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
    }

    // Handles user input for menu choices and ensures it's a valid integer
    private static int getUserChoice() {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            System.out.print("Enter your choice (1-5): ");
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Clear the newline after int input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                sc.next(); // Clear invalid input
            }
        }
        return choice;
    }

    // Adds a new task to the list
    private static void addTask() {
        System.out.print("Enter a new task: ");
        String taskDescription = sc.nextLine();
        tasks.add(new Task(taskDescription));
        System.out.println("Task added successfully.");
        viewTasks();
    }

    // Marks a task as complete
    private static void markTaskAsComplete() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        viewTasks();
        System.out.print("Enter the index of the task to mark as complete: ");
        try {
            int index = sc.nextInt();
            sc.nextLine(); // Clear the newline
            if (index >= 1 && index <= tasks.size()) {
                Task task = tasks.get(index - 1);
                task.setComplete(true);
                System.out.println("Task '" + task.getDescription() + "' marked as complete.");
            } else {
                System.out.println("Invalid index. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.next(); // Clear invalid input
        }
    }

    // Displays all tasks with their status
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTo-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " ("
                        + (task.isComplete() ? "Complete" : "Incomplete") + ")");
            }
        }
    }

    // Removes a task from the list
    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        viewTasks();
        System.out.print("Enter the index of the task to remove: ");
        try {
            int index = sc.nextInt();
            sc.nextLine(); // Clear the newline
            if (index >= 1 && index <= tasks.size()) {
                Task removedTask = tasks.remove(index - 1);
                System.out.println("Task '" + removedTask.getDescription() + "' removed.");
            } else {
                System.out.println("Invalid index. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.next(); // Clear invalid input
        }
        viewTasks();
    }
}

// A simple class to represent a task with a description and a completion status
class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
