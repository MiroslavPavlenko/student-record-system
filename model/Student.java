/**
 * Student class
 * -------------
 * Description: Represents a student record, encapsulating
 * ID, name, and grade details.
 *
 * @author Miroslav Pavlenko
 * @version 2025
 */
public class Student {
    private int studentID;
    private String firstName, lastName;
    private double grade;

    /**Default constructor
     * -------------------
     * Prints a warning and exits if no data supplied.
     *
     * pre: no user input  
     * post: message printed
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Student() {
        System.out.println("Enter information for student is invalid");
        System.exit(0);
    }

    /**regular constructor
     * -------------------
     * Creates a student with ID, name, and grade.
     *
     * pre: 6‑digit ID & grade 0‑100  
     * post: object created (invalid data replaced with defaults)
     *
     * @param studentID 6‑digit ID
     * @param firstName first name
     * @param lastName  last name
     * @param grade     grade 0‑100
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Student(int studentID, String firstName, String lastName, double grade) {
        this.studentID = (studentID > 99_999 && studentID < 1_000_000) ? studentID : 0;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.grade     = (grade >= 0.0 && grade <= 100.0) ? grade : 0.0;
    }

    /**copy constructor
     * ----------------
     * Performs a deep copy of another Student.
     *
     * pre: valid <code>other</code> supplied  
     * post: new object with identical data
     *
     * @param other student to copy
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Student(Student other) {
        this.studentID = other.studentID;
        this.firstName = new String(other.firstName);
        this.lastName  = new String(other.lastName);
        this.grade     = other.grade;
    }

    /**Student ID getter
     * ------------------
     * @return studentID
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public int getStudentID() {
        return studentID;
    }

    /**First name getter
     * -----------------
     * @return deep‑copied firstName
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public String getFirstName() {
        return new String(firstName);
    }

    /**Last name getter
     * ----------------
     * @return deep‑copied lastName
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public String getLastName() {
        return new String(lastName);
    }

    /**grade getter
     * ------------
     * @return grade
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public double getGrade() {
        return grade;
    }

    /**toString method
     * ---------------
     * @return formatted student details
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    @Override
    public String toString() {
        return "Student ID: " + studentID +
               ", First Name: " + firstName +
               ", Last Name: " + lastName +
               ", Grade: " + grade;
    }
}
