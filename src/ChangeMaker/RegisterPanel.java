package ChangeMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The RegisterPanel class creates a GUI panel for entering an amount and displaying the change.
 */
public class RegisterPanel extends JPanel {
    private Register register; // An instance of the Register class to handle making change
    private JTextField input; // A text field for entering the amount
    private PursePanel changePanel; // A panel for displaying the change

    public RegisterPanel() {
        register = new Register(); // Initialize the register
        setLayout(new BorderLayout()); // Set the layout manager to BorderLayout

        // Create a panel for the input components
        JPanel inputPanel = new JPanel();
        input = new JTextField(10); // Create a text field with a column width of 10
        inputPanel.add(new JLabel("Enter amount:")); // Add a label to the input panel
        inputPanel.add(input); // Add the text field to the input panel
        add(inputPanel, BorderLayout.NORTH); // Add the input panel to the top (north) of the main panel

        // Create the change panel to display the contents of the purse
        changePanel = new PursePanel();
        add(changePanel, BorderLayout.CENTER); // Add the change panel to the center of the main panel

        // Add an action listener to the text field to handle input events
        input.addActionListener(new InputListener());
    }

    /**
     * The InputListener class handles the action events for the input text field.
     */
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText()); // Parse the entered amount as a double
                Purse purse = register.makeChange(amount); // Use the register to make change for the entered amount
                changePanel.setPurse(purse); // Update the change panel with the new purse contents
                changePanel.repaint(); // Repaint the change panel to reflect the changes
            } catch (NumberFormatException ex) {
                // Show an error message if the entered amount is not a valid number
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount.");
            }
        }
    }
}
