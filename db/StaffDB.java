import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**StaffDB class
 * -------------
 * Description: This class handles all database operations for the staff repository.
 * It connects to a MySQL database and allows adding, finding, and removing staff.
 *
 * @author Miroslav Pavlenko
 * @version 2025
 */
public class StaffDB {
    private Connection conn;

    /**constructor
     * -----------
     * Description: Connects to the MySQL <code>staff_db</code>.  
     * Replace the placeholders below with your actual database credentials.
     *
     * pre: valid database credentials  
     * post: connection is established
     *
     * @throws SQLException if connection fails
     * @author Miroslav Pavlenko
     */
    public StaffDB() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://<HOST>:<PORT>/<DB_NAME>", // e.g. "jdbc:mysql://localhostOrPortLink:3306/staff_db"
            "<USERNAME>",
            "<PASSWORD>"
        );
    }

    /**add staff
     * ---------
     * Description: Adds a <code>Staff</code> object to the database
     *
     * pre: valid <code>Staff</code> object  
     * post: staff is inserted into <code>staff_repository</code> table
     *
     * @param s <code>Staff</code> object
     * @throws SQLException if insert fails
     * @author Miroslav Pavlenko
     */
    public void addStaff(Staff s) throws SQLException {
        String sql = """
                     INSERT INTO staff_repository
                     (staffID, firstName, lastName, role, hourlyRate, yearlySalary, bonuses)
                     VALUES (?, ?, ?, ?, ?, ?, ?)
                     """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, s.getStaffID());
        ps.setString(2, new String(s.getFirstName()));  // deep copy string
        ps.setString(3, new String(s.getLastName()));   // deep copy string
        ps.setString(4, s.getRole());
        ps.setDouble(5, s.getHourlyRate());
        ps.setDouble(6, s.getYearlySalary());
        ps.setDouble(7, s.getBonuses());
        ps.executeUpdate();
        ps.close();
    }

    /**get staff info
     * --------------
     * Description: Retrieves staff information by <code>staffID</code>
     *
     * pre: staff with entered ID exists  
     * post: formatted string with staff details is returned
     *
     * @param staffID ID to look up
     * @return formatted string of staff info or not‑found message
     * @throws SQLException if query fails
     * @author Miroslav Pavlenko
     */
    public String getStaffInfoByID(int staffID) throws SQLException {
        String sql = "SELECT * FROM staff_repository WHERE staffID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, staffID);
        ResultSet rs = ps.executeQuery();

        String result;
        if (rs.next()) {
            String firstName   = rs.getString("firstName");
            String lastName    = rs.getString("lastName");
            String role        = rs.getString("role");
            double hourlyRate  = rs.getDouble("hourlyRate");
            double yearlySalary= rs.getDouble("yearlySalary");
            double bonuses     = rs.getDouble("bonuses");

            result = """
                     Staff Info:
                     ID: %d
                     First Name: %s
                     Last Name:  %s
                     Role:       %s
                     Hourly Rate: %.2f
                     Yearly Salary: %.2f
                     Bonuses: %.2f
                     """.formatted(staffID, firstName, lastName, role,
                                    hourlyRate, yearlySalary, bonuses);
        } else {
            result = "No staff found with ID: " + staffID;
        }

        rs.close();
        ps.close();
        return result;
    }

    /**remove staff
     * ------------
     * Description: Removes a staff entry by ID from the database
     *
     * pre: staff with matching ID exists  
     * post: entry is deleted if found
     *
     * @param staffID ID of the staff member to remove
     * @return 1 if deleted, 0 if not found
     * @throws SQLException if deletion fails
     * @author Miroslav Pavlenko
     * @version 2025
     */
    public int removeStaffByID(int staffID) throws SQLException {
        String sql = "DELETE FROM staff_repository WHERE staffID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, staffID);
        int rowsAffected = ps.executeUpdate();
        ps.close();

        return rowsAffected > 0 ? 1 : 0;
    }

    /**close connection
     * ----------------
     * Description: Closes the database connection safely
     *
     * pre: connection is open  
     * post: connection is closed
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
