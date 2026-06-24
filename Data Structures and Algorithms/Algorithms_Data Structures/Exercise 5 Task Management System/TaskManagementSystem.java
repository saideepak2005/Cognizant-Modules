package exercise5;

class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID='" + taskId + '\'' +
                ", Name='" + taskName + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}

public class TaskManagementSystem {

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            System.out.println("Task added as Head: " + task.getTaskName());
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Task added: " + task.getTaskName());
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        System.out.println("\n--- Current Task List ---");
        if (head == null) {
            System.out.println("No tasks found in the system.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
        System.out.println("-------------------------\n");
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Error: Task list is empty.");
            return false;
        }

        if (head.task.getTaskId().equals(taskId)) {
            System.out.println("Deleted Head Task: " + head.task.getTaskName());
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                System.out.println("Deleted Task: " + current.next.task.getTaskName());
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        System.out.println("Error: Task with ID " + taskId + " not found.");
        return false;
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        System.out.println("--- Adding Tasks ---");
        tms.addTask(new Task("T001", "Design Database Schema", "Done"));
        tms.addTask(new Task("T002", "Implement Authentication", "In Progress"));
        tms.addTask(new Task("T003", "Write Unit Tests", "Pending"));
        tms.addTask(new Task("T004", "Setup CI/CD Pipeline", "Pending"));

        tms.traverseTasks();

        System.out.println("--- Searching for Task T002 ---");
        Task found = tms.searchTask("T002");
        System.out.println("Result: " + (found != null ? found : "Not Found"));

        System.out.println("\n--- Searching for Task T099 ---");
        Task notFound = tms.searchTask("T099");
        System.out.println("Result: " + (notFound != null ? notFound : "Not Found"));

        System.out.println("\n--- Deleting Task T003 (middle task) ---");
        tms.deleteTask("T003");
        tms.traverseTasks();

        System.out.println("--- Deleting Task T001 (head task) ---");
        tms.deleteTask("T001");
        tms.traverseTasks();

        System.out.println("--- Trying to delete non-existent Task T099 ---");
        tms.deleteTask("T099");
    }
}
