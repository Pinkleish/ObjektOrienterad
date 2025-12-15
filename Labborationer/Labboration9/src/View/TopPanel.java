package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
 * This class represents the upper part of the
 * window. It is here that the user can add new
 * stars and planets.
 * @author Calle Ketola
 */
public class TopPanel extends JPanel implements ActionListener {

    // Basic geometry
    private int width;
    private int height;

    // Widgets for selecting object type and adding
    private JComboBox<ItemTypes> listChoice;
    private JButton addItem;

    // Widgets for user input
    private JLabel nameLabel;
    private JLabel massLabel;
    private JTextField nameField;
    private JFormattedTextField massField;

    private MainPanel mainPanel;

    public TopPanel(int width, int height, MainPanel mp){
        super(new GridLayout(3,2));
        this.mainPanel = mp;

        // Set geometry
        this.width = width;
        this.height = height;
        this.setSize(this.width, this.height);
        this.setVisible(true);

        // Create and place widgets
        this.createWidgets();
        this.placeWidgets();
    }

    /**
     * This method creates and initializes all used widgets
     * @author Calle Ketola
     */
    private void createWidgets(){
        this.nameLabel = new JLabel("Name");
        this.nameField = new JTextField();

        this.massLabel = new JLabel("Mass");
        // This makes sure the mass field only takes numbers
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        this.massField = new JFormattedTextField(numberFormat);

        this.listChoice = new JComboBox<ItemTypes>(ItemTypes.values());
        this.addItem = new JButton("Add");
    }

    /**
     * This method places all the widgets
     * @author Calle Ketola
     */
    private void placeWidgets(){
        this.add(this.nameLabel);
        this.add(this.nameField);

        this.add(this.massLabel);
        this.add(this.massField);

        this.add(this.listChoice);
        this.add(this.addItem);

        this.nameLabel.setVisible(true);
        this.nameField.setVisible(true);
        this.massLabel.setVisible(true);
        this.massField.setVisible(true);
        this.listChoice.setVisible(true);
        this.addItem.setVisible(true);
    }

    /**
     * This returns the name given to the celestial body
     * @return String
     * @author Calle Ketola
     */
    public String getBodyName(){
        return this.nameField.getText();
    }

    /**
     * This method return the mass given as a double
     * @return double
     * @author Calle Ketola
     */
    public double getMass(){
        return ((Number)this.massField.getValue()).doubleValue();
    }

    /**
     * This method sends the performed action upwards
     * @param e the event to be processed
     * @author
     */
    public void actionPerformed(ActionEvent e){
        // Din kod här
    }

}
