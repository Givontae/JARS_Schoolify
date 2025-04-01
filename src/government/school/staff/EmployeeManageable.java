package government.school.staff;

/**
 * Interface for managing employee operations such as hiring and firing.
 */
public interface EmployeeManageable {
    
    /**
     * Terminates the employment of the specified employee.
     *
     * @param employee The employee to be fired.
     */
    public void fireEmployee(Employee employee);
    
    /**
     * Hires the specified employee.
     *
     * @param employee The employee to be hired.
     */
    public void hireEmployee(Employee employee);
}
