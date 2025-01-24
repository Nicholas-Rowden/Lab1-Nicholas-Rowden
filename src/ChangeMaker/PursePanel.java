package ChangeMaker;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Map;

/**
 * The PursePanel class creates a GUI panel for displaying the contents of a purse.
 */
public class PursePanel extends JPanel {
    private Purse purse; // An instance of the Purse class to hold the cash
    private static final int ICON_SIZE = 100; // Size for the scaled images
    private static final int ICON_SPACING = 10; // Spacing between icons

    /**
     * Constructor for the PursePanel class.
     * Initializes the purse and sets the layout of the panel.
     */
    public PursePanel() {
        this.purse = new Purse(); // Initialize the purse
        setLayout(new GridBagLayout()); // Set the layout manager to GridBagLayout
    }

    /**
     * Sets the purse and updates the panel to display the new contents.
     * @param purse The new purse to display.
     */
    public void setPurse(Purse purse) {
        this.purse = purse;
        updatePanel(); // Update the panel with the new purse contents
    }

    /**
     * Updates the panel to display the contents of the current purse.
     */
    private void updatePanel() {
        removeAll(); // Remove all existing components from the panel
        GridBagConstraints gbc = new GridBagConstraints(); // Constraints for component layout
        gbc.insets = new Insets(ICON_SPACING, ICON_SPACING, ICON_SPACING, ICON_SPACING); // Set insets for spacing
        gbc.anchor = GridBagConstraints.WEST; // Anchor components to the west (left)

        int x = 0; // X coordinate for GridBagLayout
        int y = 0; // Y coordinate for GridBagLayout
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey(); // Get the denomination
            int count = entry.getValue(); // Get the count of the denomination

            // Load the image icon for the denomination using a direct path
            ImageIcon icon = loadIcon("C:/Users/rowde/OneDrive/Documents/classes/Spring 2025/Java/labs/RegisterChangeMaker/resources/images/" + denomination.img());

            if (icon != null) {
                // Scale the image to the defined size
                Image scaledImage = icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(scaledImage)); // Create a label with the scaled image
                JLabel textLabel = new JLabel(denomination.name() + " x " + count); // Create a label with the denomination name and count

                gbc.gridx = x; // Set the X position for the image label
                gbc.gridy = y; // Set the Y position for the image label
                add(imageLabel, gbc); // Add the image label to the panel

                gbc.gridx = x + 1; // Set the X position for the text label
                add(textLabel, gbc); // Add the text label to the panel

                y++; // Increment Y position for the next row
            } else {
                // If the image is not found, display a text label with an error message
                JLabel textLabel = new JLabel(denomination.name() + " x " + count + " (image not found)");
                gbc.gridx = x; // Set the X position for the text label
                gbc.gridy = y; // Set the Y position for the text label
                add(textLabel, gbc); // Add the text label to the panel

                y++; // Increment Y position for the next row
            }
        }

        revalidate(); // Revalidate the layout
        repaint(); // Repaint the panel
    }

    /**
     * Loads an image icon from the specified path.
     * @param imagePath The path to the image file.
     * @return The loaded ImageIcon, or null if the image is not found.
     */
    private ImageIcon loadIcon(String imagePath) {
        try {
            java.net.URL imgURL = new File(imagePath).toURI().toURL(); // Convert the file path to a URL
            if (imgURL != null) {
                return new ImageIcon(imgURL); // Return the ImageIcon
            } else {
                System.err.println("Couldn't find file: " + imagePath); // Log an error if the file is not found
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
            return null;
        }
    }
}
