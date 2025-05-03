import java.awt.Color;
import javax.swing.*;

public class Interface extends JOptionPane {
    private Student student;
    private boolean status;
    private int confirm;

    /**default constructor
     * -------------------
     * Description: Initializes status to true and sets background color
     * 
     * pre: no input from user
     * post: interface object created with default values
     * 
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public Interface() {
        status = true;
        this.setBackground(Color.PINK);
    }

    /**draw interface
     * --------------
     * Description: Main interface that allows database selection (student or staff)
     * and enables Add, Find, and Remove operations with pop-up dialogs.
     * 
     * pre: Interface object exists
     * post: UI windows shown based on user input and choice
     * 
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public void drawInterface() {
        String[] dbOptions = {"Student Database", "Staff Database"};
        String[] studentOptions = {"Add Student", "Find Student", "Remove Student"};
        String[] staffOptions = {"Add Staff", "Find Staff", "Remove Staff"};

        // Ask which DB to work with
        int dbChoice = this.showOptionDialog(
            null,
            "Which database would you like to manage?",
            "Database Selection",
            this.DEFAULT_OPTION,
            this.QUESTION_MESSAGE,
            null,
            dbOptions,
            dbOptions[0]
        );

        if (dbChoice == this.CLOSED_OPTION) {
            status = false;
            return;
        }

        String[] options = (dbChoice == 0) ? studentOptions : staffOptions;

        do {
            StudentDB studentDB = null;
            StaffDB staffDB = null;

            try {
                if (dbChoice == 0) studentDB = new StudentDB();  // student
                else staffDB = new StaffDB();                    // staff

                int choice = this.showOptionDialog(
                    null,
                    "Choose an action",
                    "School Record System",
                    this.DEFAULT_OPTION,
                    this.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
                );

                if (choice == this.CLOSED_OPTION) {
                    status = false;
                    break;
                }

                switch (choice) {
                    case 0: // Add
                        if (dbChoice == 0) {
                            // Student Add
                            String id = this.showInputDialog("Enter Student ID:");
                            if (id == null) { status = false; break; }

                            String firstName = this.showInputDialog("Enter First Name:");
                            if (firstName == null) { status = false; break; }

                            String lastName = this.showInputDialog("Enter Last Name:");
                            if (lastName == null) { status = false; break; }

                            String grade = this.showInputDialog("Enter Final Grade:");
                            if (grade == null) { status = false; break; }

                            confirm = this.showConfirmDialog(
                                null,
                                "Is this correct?\nID: " + id + "\nFirst Name: " + firstName +
                                "\nLast Name: " + lastName + "\nGrade: " + grade,
                                "Confirm Student Info",
                                this.YES_NO_OPTION
                            );

                            if (confirm == this.CLOSED_OPTION) { status = false; break; }

                            if (confirm == this.YES_OPTION) {
                                student = new Student(Integer.parseInt(id), firstName, lastName, Double.parseDouble(grade));
                                studentDB.addStudent(student);
                                this.showMessageDialog(null, "<html>\u2714\ufe0f <b>Student added successfully</b></html>");
                            }
                        } else {
                            // Staff Add
                            String id = this.showInputDialog("Enter Staff ID:");
                            if (id == null) { status = false; break; }

                            String firstName = this.showInputDialog("Enter First Name:");
                            if (firstName == null) { status = false; break; }

                            String lastName = this.showInputDialog("Enter Last Name:");
                            if (lastName == null) { status = false; break; }

                            String role = this.showInputDialog("Enter Staff Role:");
                            if (role == null) { status = false; break; }

                            String hourlyRate = this.showInputDialog("Enter Hourly Rate:");
                            if (hourlyRate == null) { status = false; break; }

                            String yearlySalary = this.showInputDialog("Enter Yearly Salary:");
                            if (yearlySalary == null) { status = false; break; }

                            String bonuses = this.showInputDialog("Enter Bonuses:");
                            if (bonuses == null) { status = false; break; }

                            confirm = this.showConfirmDialog(
                                null,
                                "Is this correct?\nID: " + id +
                                "\nFirst Name: " + firstName +
                                "\nLast Name: " + lastName +
                                "\nRole: " + role +
                                "\nHourly Rate: " + hourlyRate +
                                "\nYearly Salary: " + yearlySalary +
                                "\nBonuses: " + bonuses,
                                "Confirm Staff Info",
                                this.YES_NO_OPTION
                            );

                            if (confirm == this.CLOSED_OPTION) { status = false; break; }

                            if (confirm == this.YES_OPTION) {
                                Staff staff = new Staff(
                                    Integer.parseInt(id),
                                    firstName,
                                    lastName,
                                    role,
                                    Double.parseDouble(hourlyRate),
                                    Double.parseDouble(yearlySalary),
                                    Double.parseDouble(bonuses)
                                );
                                staffDB.addStaff(staff);
                                this.showMessageDialog(null, "<html>\u2714\ufe0f <b>Staff added successfully</b></html>");
                            }
                        }
                        break;

                    case 1: // Find
                        if (dbChoice == 0) {
                            String studentIDSearch = this.showInputDialog("Enter Student ID:");
                            if (studentIDSearch == null) { status = false; break; }

                            String result = studentDB.getStudentInfoByID(Integer.parseInt(studentIDSearch));
                            if (result == null) {
                                this.showMessageDialog(null, "<html>\u274c No student found</html>");
                            } else {
                                this.showMessageDialog(null, result);
                            }
                        } else {
                            String staffIDSearch = this.showInputDialog("Enter Staff ID:");
                            if (staffIDSearch == null) { status = false; break; }

                            String result = staffDB.getStaffInfoByID(Integer.parseInt(staffIDSearch));
                            if (result == null) {
                                this.showMessageDialog(null, "<html>\u274c No staff found</html>");
                            } else {
                                this.showMessageDialog(null, result);
                            }
                        }
                        break;

                    case 2: // Remove
                        if (dbChoice == 0) {
                            String studentRemoveID = this.showInputDialog("Enter Student ID to remove:");
                            if (studentRemoveID == null) { status = false; break; }

                            int rows = studentDB.removeStudentByID(Integer.parseInt(studentRemoveID));
                            if (rows > 0) {
                                this.showMessageDialog(null, "<html>\u2714\ufe0f Student removed</html>");
                            } else {
                                this.showMessageDialog(null, "<html>\u274c No student found with that ID</html>");
                            }
                        } else {
                            String staffRemoveID = this.showInputDialog("Enter Staff ID to remove:");
                            if (staffRemoveID == null) { status = false; break; }

                            int rows = staffDB.removeStaffByID(Integer.parseInt(staffRemoveID));
                            if (rows > 0) {
                                this.showMessageDialog(null, "<html>\u2714\ufe0f Staff removed</html>");
                            } else {
                                this.showMessageDialog(null, "<html>\u274c No staff found with that ID</html>");
                            }
                        }
                        break;
                }

                // Ask if user wants to continue
                confirm = this.showConfirmDialog(
                    null,
                    "Would you like to do something else?",
                    "Continue",
                    this.YES_NO_OPTION,
                    this.QUESTION_MESSAGE
                );

                if (confirm == this.CLOSED_OPTION || confirm == this.NO_OPTION) status = false;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
                status = false;
            } finally {
                try {
                    if (studentDB != null) studentDB.close();
                    if (staffDB != null) staffDB.close();
                } catch (Exception e) {
                    System.err.println("Failed to close DB: " + e.getMessage());
                }
            }
        } while (status);
    }
}
