package government.school.staff;
import government.Person;
import government.school.util.Auth;

import java.util.ArrayList;

public abstract class Employee extends Person {

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
    private final static String[] departments = {"Math", "Science", "Technology", "Art", "Business", "Physical Education", "Guidance"};
    private static ArrayList<Employee> employees;


    // Constructor for Employee Class
    public Employee(int intAge, String strName, String strDepartment, String[] strShiftInterval,
                    int intYearsEmployed, double dblAnnualSalary, boolean[] blnStatus){
        super(intAge, strName);
        setDepartment(strDepartment);
        setShiftInterval(strShiftInterval);
        setYearsEmployed(intYearsEmployed);
        setAnnualSalary(dblAnnualSalary);
        setStatus(blnStatus);

        this.EMPLOYEE_ID = Auth.generateID();
        setPassword();

        employees.add(this);
    }

    // Getter Methods

    public int getEMPLOYEE_ID(){
        return this.EMPLOYEE_ID;
    }

    public String getDepartment(){
        return this.strDepartment;
    }

    public String[] getShiftInterval(){
        return this.strShiftInterval.clone();
    }

    public int getYearsEmployed(){
        return this.intYearsEmployed;
    }

    public double getAnnualSalary() {
        return this.dblAnnualSalary;
    }

    public boolean[] getStatus(){
        return this.blnStatus.clone();
    }

    //HERE!!
    public static ArrayList<Employee> getEmployees() {
        ArrayList<Employee> clonedList = new ArrayList<>();
        for (Employee employee : employees) {
            clonedList.add(employee.clone());  // assuming Employee has a properly implemented clone method
        }
        return clonedList;
    }

    @Override
    public Employee clone() {
        try {
            Employee clonedEmployee = (Employee) super.clone();  // Clone the object (shallow clone)

            // Clone the arrays (deep clone)
            clonedEmployee.strShiftInterval = this.strShiftInterval.clone();
            clonedEmployee.blnStatus = this.blnStatus.clone();

            // Return the cloned object
            return clonedEmployee;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  // If cloning is not supported (which shouldn't happen here)
            return null;
        }
    }


    // Setter Methods
    public void setPassword() {
        this.strPassword = Auth.generatePassword(8);
    }

    public void setPassword(int strPassword) {
        if (strPassword == 8){
            this.strPassword = strPassword;
        }
    }

    public void setDepartment(String strDepartment){
        if (strDepartment != null && validateDepartment(strDepartment)){
            this.strDepartment = strDepartment;
        }
    }

    public void setShiftInterval(String[] strShiftInterval){
        if (strShiftInterval != null && strShiftInterval.length == 2){
            this.strShiftInterval = strShiftInterval.clone();
        } else {
            throw new IllegalArgumentException("Shift interval cannot be null or empty.");
        }
    }

    public void setYearsEmployed(int intYearsEmployed){
        if (intYearsEmployed > 0 && intYearsEmployed < 100){
            this.intYearsEmployed = intYearsEmployed;
        } else {
            throw new IllegalArgumentException("Years employed must be a positive value.");
        }
    }

    public void setAnnualSalary(double dblAnnualSalary) {
        if (dblAnnualSalary > 0){
            this.dblAnnualSalary = dblAnnualSalary;
        } else {
            throw new IllegalArgumentException("Annual salary must be a positive value.");
        }
    }

    public void setStatus(boolean[] blnStatus){
        if (blnStatus != null && blnStatus.length == 3 && validateStatus(blnStatus)){
            this.blnStatus = blnStatus.clone();
        } else {
            throw new IllegalArgumentException("Status cannot be null.");
        }
    }

    public static void setEmployees(ArrayList<Employee> xemployees){
        if (employees != null && employees.size() > 0){
            employees = xemployees.clone();
        }
    }

    // Helper Methods

    private boolean validateDepartment(String strTarget){
        if (strTarget == null || strTarget.length() == 0){
            return false;
        }

        for (String word: departments){
            if (word.equalsIgnoreCase(strTarget)){
                return true;
            }
        }

        return false;
    }

    private boolean validateStatus(boolean[] blnStatus){
        int trueCount = 0;

        if (blnStatus != null && blnStatus.length == 3){
            for (boolean element: blnStatus){
                if (element == true) trueCount++;
            }
        }

        if (trueCount == 1) return true;

        return false;
    }

    /*
    // STORAGE METHOD(S)
    public static void saveEmployeesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employee records have been saved.");
        } catch (IOException e) {
            System.out.println("Error loading employee records");
        }
    }

    public static void loadEmployeesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("Employee records have been loaded.");
        } catch (IOException e) {
            System.out.println("Error loading employee records");
        }
    }*/


    // Overridden Methods from the Object Superclass

    @Override
    public String toString(){
        return "Name: " + super.getName() +
                "\nEmployee ID: " + this.EMPLOYEE_ID +
                "\nDepartment: " + this.strShiftInterval +
                "\nYears Employed: " + this.intYearsEmployed +
                "\nAnnual Salary: $" + this.dblAnnualSalary +
                "\nFired: " + this.blnStatus[0] +
                "\nOn Vocation: " + this.blnStatus[1] +
                "\nRetired: " + this.blnStatus[2];
    }
}
