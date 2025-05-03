/**Driver class
 * ------------
 * Description: Launches the school management interface.
 * 
 * pre: Interface class must be available
 * post: Interface window is shown and user can interact with it
 * 
 * @author Miroslav Pavlenko
 * @version 2025
 */
public class SchoolRecordSystem {

    /**main method
     * -----------
     * Description: Starts the program and calls the user interface
     * 
     * pre: none
     * post: main interface runs
     * 
     * @author Miroslav Pavlenko
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Interface ui = new Interface();
        ui.drawInterface();
    }
}
