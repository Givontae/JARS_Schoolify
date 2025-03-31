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



    // Setter Methods
    public void setPassword() {
        this.strPassword = Auth.generatePassword(8);
    }

    public void setPassword(String strPassword) {
        if (strPassword == null || strPassword.length() <= 8)
            throw new IllegalArgumentException("Password must be at least 8 characters");

        this.strPassword = strPassword;

    }

    public void setDepartment(String strDepartment){
        if (/*strDepartment != null && */validateDepartment(strDepartment)){
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

    // Helper Methods

    private boolean validateDepartment(String strTarget){
        if (strTarget == null || strTarget.isEmpty()){
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
                if (element) trueCount++;
            }
        }

        return (trueCount == 1);
    }

    // Updated getEmployees() method
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

    // Updated setEmployees() method
    public static void setEmployees(ArrayList<Employee> newEmployees) {
        if (newEmployees == null) {
            throw new IllegalArgumentException("Employee list cannot be null.");
        }
        employees = new ArrayList<>();
        for (Employee employee : newEmployees) {
            employees.add(employee.clone());
        }
    }

    // Updated clone() method
    @Override
    public Employee clone() {
        try {
            // Perform shallow cloning via super.clone()
            Employee clonedEmployee = (Employee) super.clone();
            // Deep clone mutable array fields
            clonedEmployee.strShiftInterval = (this.strShiftInterval != null) ? this.strShiftInterval.clone() : null;
            clonedEmployee.blnStatus = (this.blnStatus != null) ? this.blnStatus.clone() : null;
            return clonedEmployee;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
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
