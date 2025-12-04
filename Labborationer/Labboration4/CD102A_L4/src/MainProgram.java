

import javax.swing.*;

public class MainProgram
{
    public static void main(String[] args)
    {
        int maxNbrOfGuests = 0; // Only using 10 as a default value to make compilations possible.
        /* Write code to read max number of guests from the user by using one of
         - JOptionPane
         - Scanner and prompt
        */
        maxNbrOfGuests = Integer.parseInt(JOptionPane.showInputDialog("Ange max antal gäster:"));

        Controller controller = new Controller(maxNbrOfGuests);
    }
}
