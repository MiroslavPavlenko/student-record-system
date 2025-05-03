import java.sql.*;

/**StudentDB class
 * ---------------
 * Description: Oversees connections
 *  and interactions with the Student MySQL database on AWS RDS.
 *
 * @author Miroslav Pavlenko
 * @version 2025
 */
public class StudentDB {

    private Connection conn;

    /**constructor
     * -----------
     * Description: Connects to the MySQL <code>students_db</code>.  
     * Replace the placeholders below with your own JDBC URL, username, and password.
     *
     * pre: include a valid JDBC URL, username, and password  
     * post: connection is established
     *
     * @throws SQLException if connection fails
     * @author Miroslav Pavlenko
     */
    public StudentDB() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://<HOST>:<PORT>/<DB_NAME>", // e.g. "jdbc:mysql://localhost:3306/students_db"
            "<USERNAME>",
            "<PASSWORD>"
        );
    }

    /**add student
     * -----------
     * Description: Inserts a student object into the MySQL database.
     *
     * pre: valid student object passed  
     * post: student saved to table
     *
     * @param s student object
     * @throws SQLException if insert fails
     * @author Miroslav Pavlenko
     */
    public void addStudent(Student s) throws SQLException {
        String sql = """
                     INSERT INTO students_repository
                     (studentID, firstName, lastName, grade)
                     VALUES (?, ?, ?, ?)
                     """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, s.getStudentID());
        ps.setString(2, new String(s.getFirstName()));  // deep copy
        ps.setString(3, new String(s.getLastName()));   // deep copy
        ps.setDouble(4, s.getGrade());
        ps.executeUpdate();
        ps.close();
    }

    /**get student info
     * ----------------
     * Description: Pulls student info by ID and returns it as a string
     *
     * pre: student with given ID exists  
     * post: formatted string returned
     *
     * @param studentID ID to search for
     * @return student info or not‑found message
     * @throws SQLException if query fails
     * @author Miroslav Pavlenko
     */
    public String getStudentInfoByID(int studentID) throws SQLException {
        String sql = "SELECT * FROM students_repository WHERE studentID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, studentID);
        ResultSet rs = ps.executeQuery();

        String result;
        if (rs.next()) {
            String firstName = rs.getString("firstName");
            String lastName  = rs.getString("lastName");
            double grade     = rs.getDouble("grade");

            result = """
                     Student Info:
                     ID: %d
                     First Name: %s
                     Last Name:  %s
                     Grade: %.2f
                     """.formatted(studentID, firstName, lastName, grade);
        } else {
            result = "No student found with ID: " + studentID;
        }

        rs.close();
        ps.close();
        return result;
    }

    /**remove student
     * --------------
     * Description: Removes student from database based on ID
     *
     * pre: student exists  
     * post: student deleted from DB if found
     *
     * @param studentID ID of student to remove
     * @return 1 if removed, 0 if not found
     * @throws SQLException if delete fails
     *
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public int removeStudentByID(int studentID) throws SQLException {
        String sql = "DELETE FROM students_repository WHERE studentID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, studentID);
        int rowsAffected = ps.executeUpdate();
        ps.close();

        return rowsAffected > 0 ? 1 : 0;
    }

    /**close connection
     * ----------------
     * Description: Closes the database connection safely
     *
     * pre: connection is open  
     * post: connection closed
     *
     * @throws SQLException if closing fails
     * @author Miroslav Pavlenko
     */
    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
