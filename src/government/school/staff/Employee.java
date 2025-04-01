/**************************************************************************
* File name:
* Employee.java
*
* Description:
* This file contains an abstract class Employee that extends the
* Person class and implements Cloneable. It includes fields,
* constructors, getters, setters, helper methods, and a clone
* method.
*
* Author:
* G. Murzaku
*
* Date:
* February 02 2024
*
* Concepts:
* Inheritance, interface implementation, cloning, array copying,
* and exception handling.
**************************************************************************/

package government.school.staff;

import government.Person;
import government.school.util.Auth;
import java.util.ArrayList;

public abstract class Employee extends Person implements Cloneable {

    // Fields
    private final int EMPLOYEE_ID;
    private String strPassword;
    private String strDepartment;
    private String[] strShiftInterval;
    private int intYearsEmployed;
    private double dblAnnualSalary;
    // Fired, vacation, retired
    private boolean[] blnStatus;

    // Static Fields
    private final static String[] departments = {"Math", "Science", "Technology",
        "Art", "Business", "Physical Education", "Guidance"};
    private static ArrayList<Employee> employees;

    /**********************************************************************
    * Method name:
    * Employee (Constructor)
    *
    * Description:
    * Constructs an Employee object. It initializes the fields using
    * the provided parameters and generates a unique EMPLOYEE_ID.
    *
    * Parameters:
    * int   - Age of the employee.
    * String - Name of the employee.
    * String - Password for the employee.
    * String - Department name.
    * String[] - Shift interval (expected length 2).
    * int   - Years employed.
    * double- Annual salary.
    * boolean[] - Status array (3 elements: fired, vacation, retired).
    *
    * Return:
    * None.
    **********************************************************************/
    public Employee(int intAge, String strName, String strPassword,
            String strDepartment, String[] strShiftInterval, int intYearsEmployed,
            double dblAnnualSalary, boolean[] blnStatus) {
        super(intAge, strName);
        setDepartment(strDepartment);
        setShiftInterval(strShiftInterval);
        setYearsEmployed(intYearsEmployed);
        setAnnualSalary(dblAnnualSalary);
        setStatus(blnStatus);
        setPassword(strPassword);

        // Generate a unique employee ID.
        this.EMPLOYEE_ID = Auth.generateID();
        // Generate a new password if necessary.
        setPassword();

        employees.add(this);
    }

    /**********************************************************************
    * Method name:
    * getEMPLOYEE_ID
    *
    * Description:
    * Returns the unique employee ID.
    *
    * Parameters:
    * None.
    *
    * Return:
    * int - Employee ID.
    **********************************************************************/
    public int getEMPLOYEE_ID() {
        return this.EMPLOYEE_ID;
    }

    /**********************************************************************
    * Method name:
    * getDepartment
    *
    * Description:
    * Returns the department name.
    *
    * Parameters:
    * None.
    *
    * Return:
    * String - Department name.
    **********************************************************************/
    public String getDepartment() {
        return this.strDepartment;
    }

    /**********************************************************************
    * Method name:
    * getShiftInterval
    *
    * Description:
    * Returns a clone of the shift interval array.
    *
    * Parameters:
    * None.
    *
    * Return:
    * String[] - Shift interval array.
    **********************************************************************/
    public String[] getShiftInterval() {
        return this.strShiftInterval.clone();
    }

    /**********************************************************************
    * Method name:
    * getYearsEmployed
    *
    * Description:
    * Returns the number of years employed.
    *
    * Parameters:
    * None.
    *
    * Return:
    * int - Years employed.
    **********************************************************************/
    public int getYearsEmployed() {
        return this.intYearsEmployed;
    }

    /**********************************************************************
    * Method name:
    * getAnnualSalary
    *
    * Description:
    * Returns the annual salary.
    *
    * Parameters:
    * None.
    *
    * Return:
    * double - Annual salary.
    **********************************************************************/
    public double getAnnualSalary() {
        return this.dblAnnualSalary;
    }

    /**********************************************************************
    * Method name:
    * getStatus
    *
    * Description:
    * Returns a clone of the status array.
    *
    * Parameters:
    * None.
    *
    * Return:
    * boolean[] - Status array.
    **********************************************************************/
    public boolean[] getStatus() {
        return this.blnStatus.clone();
    }

    /**********************************************************************
    * Method name:
    * setPassword (no parameter)
    *
    * Description:
    * Sets a new password by generating an 8-character password.
    *
    * Parameters:
    * None.
    *
    * Return:
    * None.
    **********************************************************************/
    public void setPassword() {
        this.strPassword = Auth.generatePassword(8);
    }

    /**********************************************************************
    * Method name:
    * setPassword
    *
    * Description:
    * Sets the password if it meets the minimum length.
    *
    * Parameters:
    * String - New password.
    *
    * Return:
    * None.
    *
    * Restrictions:
    * Password must be at least 8 characters.
    **********************************************************************/
    public void setPassword(String strPassword) {
        if (strPassword == null || strPassword.length() <= 8)
            throw new IllegalArgumentException("Password must be at least 8 characters");
        this.strPassword = strPassword;
    }

    /**********************************************************************
    * Method name:
    * setDepartment
    *
    * Description:
    * Sets the department if it is valid.
    *
    * Parameters:
    * String - Department name.
    *
    * Return:
    * None.
    **********************************************************************/
    public void setDepartment(String strDepartment) {
        if (validateDepartment(strDepartment)) {
            this.strDepartment = strDepartment;
        }
    }

    /**********************************************************************
    * Method name:
    * setShiftInterval
    *
    * Description:
    * Sets the shift interval after validating the array length.
    *
    * Parameters:
    * String[] - Shift interval array (length must be 2).
    *
    * Return:
    * None.
    *
    * Restrictions:
    * Shift interval cannot be null or empty.
    **********************************************************************/
    public void setShiftInterval(String[] strShiftInterval) {
        if (strShiftInterval != null && strShiftInterval.length == 2) {
            this.strShiftInterval = strShiftInterval.clone();
        } else {
            throw new IllegalArgumentException("Shift interval cannot be null or empty.");
        }
    }

    /**********************************************************************
    * Method name:
    * setYearsEmployed
    *
    * Description:
    * Sets the years employed after validating the input.
    *
    * Parameters:
    * int - Years employed (must be positive and less than 100).
    *
    * Return:
    * None.
    **********************************************************************/
    public void setYearsEmployed(int intYearsEmployed) {
        if (intYearsEmployed > 0 && intYearsEmployed < 100) {
            this.intYearsEmployed = intYearsEmployed;
        } else {
            throw new IllegalArgumentException("Years employed must be a positive value.");
        }
    }

    /**********************************************************************
    * Method name:
    * setAnnualSalary
    *
    * Description:
    * Sets the annual salary after ensuring it is positive.
    *
    * Parameters:
    * double - Annual salary.
    *
    * Return:
    * None.
    **********************************************************************/
    public void setAnnualSalary(double dblAnnualSalary) {
        if (dblAnnualSalary > 0) {
            this.dblAnnualSalary = dblAnnualSalary;
        } else {
            throw new IllegalArgumentException("Annual salary must be a positive value.");
        }
    }

    /**********************************************************************
    * Method name:
    * setStatus
    *
    * Description:
    * Sets the status array after validating its length and content.
    *
    * Parameters:
    * boolean[] - Status array (length 3).
    *
    * Return:
    * None.
    *
    * Restrictions:
    * Exactly one element must be true.
    **********************************************************************/
    public void setStatus(boolean[] blnStatus) {
        if (blnStatus != null && blnStatus.length == 3 && validateStatus(blnStatus)) {
            this.blnStatus = blnStatus.clone();
        } else {
            throw new IllegalArgumentException("Status cannot be null.");
        }
    }

    /**********************************************************************
    * Method name:
    * validateDepartment
    *
    * Description:
    * Validates that the department string is non-null and matches one
    * of the predefined departments.
    *
    * Parameters:
    * String - Target department.
    *
    * Return:
    * boolean - True if valid; false otherwise.
    **********************************************************************/
    private boolean validateDepartment(String strTarget) {
        if (strTarget == null || strTarget.isEmpty()) {
            return false;
        }
        for (String word : departments) {
            if (word.equalsIgnoreCase(strTarget)) {
                return true;
            }
        }
        return false;
    }

    /**********************************************************************
    * Method name:
    * validateStatus
    *
    * Description:
    * Validates the status array to ensure exactly one true value.
    *
    * Parameters:
    * boolean[] - Status array.
    *
    * Return:
    * boolean - True if exactly one element is true.
    **********************************************************************/
    private boolean validateStatus(boolean[] blnStatus) {
        int trueCount = 0;
        if (blnStatus != null && blnStatus.length == 3) {
            for (boolean element : blnStatus) {
                if (element)
                    trueCount++;
            }
        }
        return (trueCount == 1);
    }

    /**********************************************************************
    * Method name:
    * getEmployees
    *
    * Description:
    * Returns a cloned list of all employees.
    *
    * Parameters:
    * None.
    *
    * Return:
    * ArrayList<Employee> - Cloned list of employees.
    **********************************************************************/
    public static ArrayList<Employee> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        ArrayList<Employee> clonedList = new ArrayList<>();
        for (Employee employee : employees) {
            clonedList.add(employee.clone());
        }
        return clonedList;
    }

    /**********************************************************************
    * Method name:
    * setEmployees
    *
    * Description:
    * Replaces the current employee list with a new cloned list.
    *
    * Parameters:
    * ArrayList<Employee> - New employee list.
    *
    * Return:
    * None.
    *
    * Restrictions:
    * New employee list cannot be null.
    **********************************************************************/
    public static void setEmployees(ArrayList<Employee> newEmployees) {
        if (newEmployees == null) {
            throw new IllegalArgumentException("Employee list cannot be null.");
        }
        employees = new ArrayList<>();
        for (Employee employee : newEmployees) {
            employees.add(employee.clone());
        }
    }

    /**********************************************************************
    * Method name:
    * clone
    *
    * Description:
    * Creates and returns a clone of the current Employee object.
    * This method performs a shallow clone of the object and deep clones
    * the mutable array fields.
    *
    * Parameters:
    * None.
    *
    * Return:
    * Employee - Cloned Employee object.
    *
    * Restrictions:
    * Throws AssertionError if cloning is not supported.
    **********************************************************************/
    @Override
    public Employee clone() {
        try {
            // Perform shallow cloning via super.clone()
            Employee clonedEmployee = (Employee) super.clone();
            // Deep clone mutable array fields
            clonedEmployee.strShiftInterval = (this.strShiftInterval != null) ?
                this.strShiftInterval.clone() : null;
            clonedEmployee.blnStatus = (this.blnStatus != null) ?
                this.blnStatus.clone() : null;
            return clonedEmployee;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    /*
    // STORAGE METHOD(S)
    // The following methods can be used to save and load employee records.
    // They are currently commented out.
    public static void saveEmployeesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employee records have been saved.");
        } catch (IOException e) {
            System.out.println("Error loading employee records");
        }
    }

    public static void loadEmployeesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("Employee records have been loaded.");
        } catch (IOException e) {
            System.out.println("Error loading employee records");
        }
    }
    */

    /**********************************************************************
    * Method name:
    * toString
    *
    * Description:
    * Returns a string representation of the Employee object.
    *
    * Parameters:
    * None.
    *
    * Return:
    * String - Concatenated details of the employee.
    **********************************************************************/
    @Override
    public String toString() {
        return "Name: " + super.getName() +
               "\nEmployee ID: " + this.EMPLOYEE_ID +
               "\nDepartment: " + this.strDepartment +
               "\nYears Employed: " + this.intYearsEmployed +
               "\nAnnual Salary: $" + this.dblAnnualSalary +
               "\nFired: " + this.blnStatus[0] +
               "\nOn Vacation: " + this.blnStatus[1] +
               "\nRetired: " + this.blnStatus[2];
    }
}
