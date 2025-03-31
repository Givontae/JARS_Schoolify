/**************************************************************************
* File name: Counsellor.java
*
* Description:
* This file contains the Counsellor class, which extends Employee.
* It represents a school counsellor with additional attributes such
* as certification details and the assigned student group.
*
* Author:
* [Your Name]
*
* Date: March 31 2025
*
* Concepts:
* - Inheritance in Java
* - Constructor chaining using super()
* - Encapsulation via getter and setter methods
**************************************************************************/

package government.school.staff;

public class Counsellor extends Employee {

    /**************************************************************************
    * Field Declaration
    *************************************************************************/
    private String strCounsellingCertification; // Certification details.
    private String strCounsellorAlpha; // Assigned student group.

    /**************************************************************************
    * Constructor: Counsellor
    *
    * Description:
    * Initializes a Counsellor object by calling the Employee constructor
    * and setting counsellor-specific attributes such as certification
    * and assigned student group.
    *
    * Parameters:
    * int intAge - Age of the counsellor.
    * String strName - Name of the counsellor.
    * String[] shiftInterval - Array representing shift intervals.
    * int intYearsEmployed - Years of employment.
    * double dblAnnualSalary - Annual salary.
    * boolean[] blnStatus - Array of employment statuses.
    * String strCounsellingCertification - Counselling certification.
    * String strCounsellorAlpha - Assigned student group.
    *************************************************************************/
    public Counsellor(int intAge, String strName, String[] shiftInterval,
                      int intYearsEmployed, double dblAnnualSalary, 
                      boolean[] blnStatus, String strCounsellingCertification, 
                      String strCounsellorAlpha) {
        super(intAge, strName, "Guidance", shiftInterval, intYearsEmployed, 
              dblAnnualSalary, blnStatus);
        setCounsellingCertification(strCounsellingCertification);
        setCounsellorAlpha(strCounsellorAlpha);
    }

    /**************************************************************************
    * Method: getCounsellingCertification
    *
    * Description:
    * Getter method for the counsellor's certification.
    *
    * Return:
    * String - The certification details.
    *************************************************************************/
    public String getCounsellingCertification() {
        return this.strCounsellingCertification;
    }

    /**************************************************************************
    * Method: getCounsellorAlpha
    *
    * Description:
    * Getter method for the counsellor's assigned student group.
    *
    * Return:
    * String - The assigned student group identifier.
    *************************************************************************/
    public String getCounsellorAlpha() {
        return this.strCounsellorAlpha;
    }

    /**************************************************************************
    * Method: setCounsellingCertification
    *
    * Description:
    * Setter method for the counsellor's certification.
    *
    * Parameters:
    * String strCounsellingCertification - The new certification details.
    *************************************************************************/
    public void setCounsellingCertification(String strCounsellingCertification) {
        if (strCounsellingCertification != null && 
            strCounsellingCertification.length() > 0) {
            this.strCounsellingCertification = strCounsellingCertification;
        }
    }

    /**************************************************************************
    * Method: setCounsellorAlpha
    *
    * Description:
    * Setter method for the counsellor's assigned student group.
    *
    * Parameters:
    * String strCounsellorAlpha - The new assigned student group.
    *************************************************************************/
    public void setCounsellorAlpha(String strCounsellorAlpha) {
        if (strCounsellorAlpha != null && strCounsellorAlpha.length() > 0) {
            this.strCounsellorAlpha = strCounsellorAlpha;
        }
    }

} /* End of Counsellor class */
