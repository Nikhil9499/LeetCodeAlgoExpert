package proxy;

public class ProxyEmployeeDao implements IEmployeeDao {
    private EmployeeDao employeeDao; // HAS-A relationship with original Dao object.

    public ProxyEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void createEmployee(String client, Employee employee) {
        if ("ADMIN".equals(client)) {
            employeeDao.createEmployee(client, employee);
            return;
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public void updateEmployee(String client, Employee updatedEmployee) {
        if ("ADMIN".equals(client)) {
            employeeDao.updateEmployee(client, updatedEmployee);
            return;
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public void deleteEmployee(String client, int employeeId) {
        if ("ADMIN".equals(client)) {
            employeeDao.deleteEmployee(client, employeeId);
            return;
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public Employee getEmployee(String client, int employeeId) {
        if ("ADMIN".equals(client) || "USER".equals(client)) {
            return employeeDao.getEmployee(client, employeeId);
        }
        throw new RuntimeException("Access Denied");
    }
}
