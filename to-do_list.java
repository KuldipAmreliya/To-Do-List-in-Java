import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private boolean isComplete;

    public Task(String title) {
        this.title = title;
        this.isComplete = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markAsComplete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return (isComplete ? "[X] " : "[ ] ") + title;
    }
}

class todolist{
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nTo-Do List Application:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // clear the invalid input
                continue;
            }

            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter task title:");
                    String title = scanner.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.println("Enter task number to mark as complete:");
                    int taskNumber = 0;
                    try {
                        taskNumber = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid task number.");
                        scanner.next(); // clear the invalid input
                        continue;
                    }
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        tasks.get(taskNumber - 1).markAsComplete();
                        System.out.println("Task marked as complete.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    displayTasks();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
