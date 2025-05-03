/**
 * Staff class
 * -----------
 * Description: Represents a staff member and encapsulates
 * basic payroll‑related data such as ID, name, role, rates,
 * salary, and bonuses.
 *
 * @author Miroslav Pavlenko
 * @version 2025
 */
public class Staff {
    private String role, firstName, lastName;
    private int staffID;
    private double hourlyRate, yearlySalary, bonuses;

    /**default constructor
     * -------------------
     * Description: Prints message if nothing was entered
     *
     * pre: no input from user
     * post: message prints
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Staff() {
        System.out.println("Enter information for staff is invalid");
        System.exit(0);
    }

    /**constructor
     * -----------
     * Description: primary constructor for normal use
     *
     * pre: id is 6 digits
     * post: object created
     *
     * @param staffID    6‑digit ID
     * @param firstName  staff first name
     * @param lastName   staff last name
     * @param role       staff role
     * @param hourlyRate hourly wage
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Staff(int staffID,
                 String firstName,
                 String lastName,
                 String role,
                 double hourlyRate) {

        if (staffID > 99_999 && staffID < 1_000_000) this.staffID = staffID;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.role        = role;
        this.hourlyRate  = hourlyRate;
    }

    /**overloaded constructor
     * ----------------------
     * Description: constructor with yearly salary
     *
     * pre: id is 6 digits & yearly salary set
     * post: object created with salary info
     *
     * @param staffID      6‑digit ID
     * @param firstName    staff first name
     * @param lastName     staff last name
     * @param role         staff role
     * @param hourlyRate   hourly wage
     * @param yearlySalary yearly salary
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Staff(int staffID,
                 String firstName,
                 String lastName,
                 String role,
                 double hourlyRate,
                 double yearlySalary) {

        if (staffID > 99_999 && staffID < 1_000_000) this.staffID = staffID;
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.role         = role;
        this.hourlyRate   = hourlyRate;
        this.yearlySalary = yearlySalary;
    }

    /**overloaded constructor
     * ----------------------
     * Description: constructor with full salary details
     *
     * pre: id is 6 digits & yearly salary & bonuses set
     * post: object created with full salary details
     *
     * @param staffID      6‑digit ID
     * @param firstName    staff first name
     * @param lastName     staff last name
     * @param role         staff role
     * @param hourlyRate   hourly wage
     * @param yearlySalary yearly salary
     * @param bonuses      bonus total
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Staff(int staffID,
                 String firstName,
                 String lastName,
                 String role,
                 double hourlyRate,
                 double yearlySalary,
                 double bonuses) {

        if (staffID > 99_999 && staffID < 1_000_000) this.staffID = staffID;
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.role         = role;
        this.hourlyRate   = hourlyRate;
        this.yearlySalary = yearlySalary;
        this.bonuses      = bonuses;
    }

    /**copy constructor
     * ----------------
     * Description: deep copy constructor
     *
     * pre: other staff exists
     * post: creates deep copy of object
     *
     * @param other staff object to copy
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Staff(Staff other) {
        this.staffID      = other.staffID;
        this.firstName    = new String(other.firstName);
        this.lastName     = new String(other.lastName);
        this.role         = new String(other.role);
        this.hourlyRate   = other.hourlyRate;
        this.yearlySalary = other.yearlySalary;
        this.bonuses      = other.bonuses;
    }

    /**staffID getter
     * --------------
     * @return staffID
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public int getStaffID() {
        return staffID;
    }

    /**first name getter
     * -----------------
     * @return deep‑copied firstName
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public String getFirstName() {
        return new String(firstName);
    }

    /**last name getter
     * ----------------
     * @return deep‑copied lastName
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public String getLastName() {
        return new String(lastName);
    }

    /**role getter
     * -----------
     * @return deep‑copied role
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public String getRole() {
        return new String(role);
    }

    /**hourly rate getter
     * ------------------
     * @return hourlyRate
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**yearly salary getter
     * --------------------
     * @return yearlySalary
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public double getYearlySalary() {
        return yearlySalary;
    }

    /**bonuses getter
     * --------------
     * @return bonuses
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public double getBonuses() {
        return bonuses;
    }

    /**test
     * ----
     * Description: simple test harness
     *
     * pre: test name & boolean result
     * post: result message printed
     *
     * @param testName name of the test
     * @param testPass true if passed
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public void test(String testName, boolean testPass) {
        System.out.println((testPass ? "Pass: " : "Fail: ") + testName);
    }
}
