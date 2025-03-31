/**************************************************************************
* File name: Administrator.java
*
* Description:
* This file contains the Administrator class which extends Employee
* and implements EmployeeManageable. It handles administrator-specific
* attributes and operations, including managing school budgets.
*
* Author:
* [Your Name]
*
* Date: March 31 2025
*
* Concepts:
* - Inheritance and interfaces in Java
* - Constructor chaining using super()
* - Overriding methods from the superclass
**************************************************************************/

package government.school.staff;

public class Administrator extends Employee 
        implements EmployeeManageable {

    /**************************************************************************
    * Field Declaration
    *************************************************************************/
    private double dblSchoolBudget; // Budget for the school.

    /**************************************************************************
    * Constructor: Administrator
    *
    * Description:
    * Initializes an Administrator object by calling the Employee
    * constructor and setting the school budget. Also resets the
    * department and password.
    *
    * Parameters:
    * int intAge - Age of the administrator.
    * String strName - Name of the administrator.
    * String strPassword - Password for login.
    * String strDepartment - Department name.
    * String[] shiftInterval - Array representing shift intervals.
    * int intYearsEmployed - Years of employment.
    * double dblAnnualSalary - Annual salary.
    * boolean[] blnStatus - Array of employment statuses.
    * double dblSchoolBudget - Budget allocated for the school.
    *************************************************************************/
    public Administrator(int intAge, String strName, String strPassword, 
                           String strDepartment, String[] shiftInterval,
                           int intYearsEmployed, double dblAnnualSalary, 
                           boolean[] blnStatus,
                           double dblSchoolBudget) {
        super(intAge, strName, strPassword, strDepartment, shiftInterval, 
              intYearsEmployed, dblAnnualSalary, blnStatus);
        setSchoolBudget(dblSchoolBudget);
        setDepartment(strDepartment);
        setPassword(strPassword);
    }

    /**************************************************************************
    * Method: getSchoolBudget
    *
    * Description:
    * Getter method for the school's budget.
    *
    * Return:
    * double - The current school budget.
    *************************************************************************/
    public double getSchoolBudget() {
        return this.dblSchoolBudget;
    }

    /**************************************************************************
    * Method: setSchoolBudget
    *
    * Description:
    * Setter method for the school's budget.
    *
    * Parameters:
    * double dblSchoolBudget - The new school budget.
    *
    * Note:
    * No range check is done as the budget may be negative or zero.
    *************************************************************************/
    public void setSchoolBudget(double dblSchoolBudget) {
        // Directly set the school budget.
        this.dblSchoolBudget = dblSchoolBudget;
    }

    /**************************************************************************
    * Method: fireEmployee
    *
    * Description:
    * Implements firing an employee. The employee's status is updated.
    *
    * Parameters:
    * Employee employee - The employee to be fired.
    *************************************************************************/
    public void fireEmployee(Employee employee) {
        // Set status: fired=true, other flags false.
        boolean[] newEmployeeStatus = {true, false, false};
        employee.setStatus(newEmployeeStatus);
    }

    /**************************************************************************
    * Method: hireEmployee
    *
    * Description:
    * Implements hiring an employee.
    *
    * Parameters:
    * Employee employee - The employee to be hired.
    *
    * Note:
    * Code for adding the employee to the list is commented out.
    *************************************************************************/
    public void hireEmployee(Employee employee) {
        // Add the employee to the records.
        // Employee.setEmployees(Employee.getEmployees().add(employee));
    }

    /**************************************************************************
    * Method: toString
    *
    * Description:
    * Overridden method to provide a string representation of
    * the Administrator object.
    *
    * Return:
    * String - Formatted string including the position and details.
    *************************************************************************/
    @Override
    public String toString() {
        return "Position: Administrator\n" + super.toString();
    }
} /* End of Administrator class */
