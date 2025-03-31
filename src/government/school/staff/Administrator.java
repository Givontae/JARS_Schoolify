package government.school.staff;

public class Administrator extends Employee implements EmployeeManageable {
    // Do not delete records if fired, on vocation, or retired

    // Fields
    private double dblSchoolBudget;

    // Constructor for Administrator Class
    public Administrator(int intAge, String strName, String strPassword, String strDepartment, String[] shiftInterval,
                         int intYearsEmployed, double dblAnnualSalary, boolean[] blnStatus,
                         double dblSchoolBudget){
        super(intAge, strName, strPassword, strDepartment, shiftInterval, intYearsEmployed, dblAnnualSalary, blnStatus);
        setSchoolBudget(dblSchoolBudget);
        setDepartment(strDepartment);
        setPassword(strPassword);
    }

    // Getter Method

    public double getSchoolBudget(){
        return this.dblSchoolBudget;
    }

    // Setter Method

    public void setSchoolBudget(double dblSchoolBudget){
        // No checking parameter value range since the budget can be negative or zero
        this.dblSchoolBudget = dblSchoolBudget;
    }

    // Implementing Methods inherited from EmployeeManageable Interface

    public void fireEmployee(Employee employee){
        boolean[] newEmployeeStatus = {true, false, false};
        employee.setStatus(newEmployeeStatus);
    }

    public void hireEmployee(Employee employee){
        //Employee.setEmployees(Employee.getEmployees().add(employee));
    }


    // Overridden Methods from the Employee Superclass
    @Override
    public String toString(){
        return "Position: Administrator\n" + super.toString();
    }
}
