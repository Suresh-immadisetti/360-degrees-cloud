package employee_management_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementJdbcApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementJdbcApplication.class, args);
        System.out.println("✅ Employee Management System Started Successfully");
    }

    @Override
    public void run(String... args) {
        System.out.println("➡️ Running sample operations...");

        // Add a new employee
        Employee employee = new Employee("John Doe", "IT", 60000.0);
        Employee savedEmployee = employeeService.addEmployee(employee);
        System.out.println("✔ Employee added: " + savedEmployee);

        // Fetch and display all employees
        System.out.println("\n📋 List of Employees:");
        employeeService.getAllEmployees().forEach(System.out::println);
    }
}
