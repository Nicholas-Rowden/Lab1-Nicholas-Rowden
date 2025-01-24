package ChangeMaker;

import javax.swing.*;

/**
 * The MakingChange class sets up the GUI (Graphical User Interface) for making change.
 */
public class MakingChange {
    public static void main(String[] args) {
        // Create a new JFrame (a window) with the title "Making Change"
        JFrame frame = new JFrame("Making Change");

        // Set the default close operation so that the application exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a new RegisterPanel to the frame
        frame.add(new RegisterPanel());

        // Pack the frame to fit the preferred sizes of its components
        frame.pack();

        // Make the frame visible
        frame.setVisible(true);
    }
}
