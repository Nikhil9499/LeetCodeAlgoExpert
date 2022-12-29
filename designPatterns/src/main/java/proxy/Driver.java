package proxy;

/*
 *   Proxy DP is used when we want to have some pre-validation or post-validation, caching, logging, etc.
 *   Here in the example, based on roles, certain actions are allowed.
 * */

public class Driver {
    public static void main(String[] args) {
        IEmployeeDao proxyEmployeeDao = new ProxyEmployeeDao(new EmployeeDao());
        try {
            proxyEmployeeDao.createEmployee("ADMIN", new Employee());
            proxyEmployeeDao.createEmployee("USER", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            proxyEmployeeDao.updateEmployee("ADMIN", new Employee());
            proxyEmployeeDao.updateEmployee("USER", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            proxyEmployeeDao.deleteEmployee("ADMIN", 1);
            proxyEmployeeDao.deleteEmployee("USER", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            proxyEmployeeDao.getEmployee("ADMIN", 12);
            proxyEmployeeDao.getEmployee("USER", 12);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
