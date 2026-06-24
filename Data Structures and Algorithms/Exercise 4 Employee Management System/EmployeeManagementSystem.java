package exercise4;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + employeeId + '\'' +
                ", Name='" + name + '\'' +
                ", Position='" + position + '\'' +
                ", Salary=$" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Error: Cannot add employee. System is at full capacity (" + employees.length + ").");
            return false;
        }
        employees[count] = employee;
        count++;
        System.out.println("Employee added successfully: " + employee.getName());
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        System.out.println("\n--- Current Employees List (" + count + "/" + employees.length + ") ---");
        if (count == 0) {
            System.out.println("No employee records found.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("-----------------------------------------\n");
    }

    public boolean deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Error: Employee with ID " + employeeId + " not found.");
            return false;
        }

        String deletedName = employees[index].getName();
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null;
        count--;
        System.out.println("Deleted employee: " + deletedName);
        return true;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        System.out.println("--- Adding Employees ---");
        ems.addEmployee(new Employee("E001", "Alice Smith", "Software Engineer", 85000));
        ems.addEmployee(new Employee("E002", "Bob Jones", "Product Manager", 95000));
        ems.addEmployee(new Employee("E003", "Charlie Brown", "QA Analyst", 65000));
        ems.addEmployee(new Employee("E004", "Diana Prince", "UI/UX Designer", 75000));
        ems.addEmployee(new Employee("E005", "Evan Wright", "DevOps Engineer", 90000));

        System.out.println("\n--- Exceeding Capacity ---");
        ems.addEmployee(new Employee("E006", "Frank Miller", "HR Specialist", 60000));

        ems.traverseEmployees();

        System.out.println("--- Searching for Employee E003 ---");
        Employee found = ems.searchEmployee("E003");
        System.out.println("Result: " + (found != null ? found : "Not Found"));

        System.out.println("\n--- Searching for Employee E099 ---");
        Employee notFound = ems.searchEmployee("E099");
        System.out.println("Result: " + (notFound != null ? notFound : "Not Found"));

        System.out.println("\n--- Deleting Employee E002 ---");
        ems.deleteEmployee("E002");
        ems.traverseEmployees();

        System.out.println("--- Adding Employee E006 again ---");
        ems.addEmployee(new Employee("E006", "Frank Miller", "HR Specialist", 60000));
        ems.traverseEmployees();
    }
}
