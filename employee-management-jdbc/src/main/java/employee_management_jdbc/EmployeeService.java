package employee_management_jdbc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create an Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By ID
    public Optional<Employee> getEmployeeById(Long id) {  // Accepts int
        return employeeRepository.findById(Long.valueOf(id)); // Convert int to Long
    }

    // Update Employee Salary
    public Employee updateEmployeeSalary(Long id, double newSalary) {  // Accepts int
        Optional<Employee> optionalEmployee = employeeRepository.findById(Long.valueOf(id)); // Convert int to Long
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setSalary(newSalary);
            return employeeRepository.save(employee);
        }
        return null;
    }

    // Delete Employee
    public void deleteEmployee(Long id) {  // Accepts int
        employeeRepository.deleteById(Long.valueOf(id)); // Convert int to Long
    }
}
