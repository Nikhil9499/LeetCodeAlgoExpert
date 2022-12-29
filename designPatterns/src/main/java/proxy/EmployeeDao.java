package proxy;

public class EmployeeDao implements IEmployeeDao {
    @Override
    public void createEmployee(String client, Employee employee) {
        System.out.println("employee created successfully");
    }

    @Override
    public void updateEmployee(String client, Employee updatedEmployee) {
        System.out.println("employee updated successfully");
    }

    @Override
    public void deleteEmployee(String client, int employeeId) {
        System.out.println("employee deleted successfully");
    }

    @Override
    public Employee getEmployee(String client, int employeeId) {
        System.out.println("employee get request processed successfully");
        return new Employee();
    }
}
