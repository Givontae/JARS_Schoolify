package government.school.staff;

public class Counsellor extends Employee {
    // Fields
    private String strCounsellingCertification;
    private String strCounsellorAlpha;

    // Constructor for Consellor Class
    public Counsellor(int intAge, String strName, String[] shiftInterval,
                      int intYearsEmployed, double dblAnnualSalary, boolean[] blnStatus,
                      String strCounsellingCertification, String strCounsellorAlpha){
        super(intAge, strName, "Guidance", shiftInterval, intYearsEmployed, dblAnnualSalary, blnStatus);
        setCounsellingCertification(strCounsellingCertification);
        setCounsellorAlpha(strCounsellorAlpha);
    }

    // Getter Methods
    public String getCounsellingCertification(){
        return this.strCounsellingCertification;
    }

    public String getCounsellorAlpha(){
        return this.strCounsellorAlpha;
    }

    // Setter Methods
    public void setCounsellingCertification(String strCounsellingCertification){
        if (strCounsellingCertification != null && strCounsellingCertification.length() > 0){
            this.strCounsellingCertification = strCounsellingCertification;
        }
    }

    public void setCounsellorAlpha(String strCounsellorAlpha){
        if (strCounsellorAlpha != null && strCounsellorAlpha.length() > 0){
            this.strCounsellorAlpha = strCounsellorAlpha;
        }
    }

    // Overridden Methods from the Employee Superclass
    @Override
    public String toString(){
        return "Position: Counsellor\n" + super.toString() + "\Counselling Certification: "
                + strCounsellingCertification + "\nCounsellor Alpha: " + strCounsellorAlpha;
    }
}