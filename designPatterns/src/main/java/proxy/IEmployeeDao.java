package proxy;

public interface IEmployeeDao {
    void createEmployee(String client, Employee employee) throws Exception;

    void updateEmployee(String client, Employee updatedEmployee) throws Exception;

    void deleteEmployee(String client, int employeeId) throws Exception;

    Employee getEmployee(String client, int employeeId) throws Exception;
}
