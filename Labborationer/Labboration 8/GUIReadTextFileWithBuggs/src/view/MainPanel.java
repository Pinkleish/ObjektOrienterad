package view;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.event.ListSelectionEvent;

public class MainPanel extends JPanel implements ActionListener, ListSelectionListener
{
    private Controller controller;
    private int width;
    private int height;

    //Declare a button
    private JButton btnOK;
    private JLabel lblMessage;
    private JList lstOutput;

    public MainPanel(Controller controller, int width, int height)
    {
        this.controller = controller;
        this.width = width;
        this.height = height;
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        createComponents();
    }
    private void createComponents()
    {
        //2.set size - mainpanel
        setSize(new Dimension(width, height));

        // Create a list to hold a number of strings.
        createList();
        createButton();
        createLabel();

    }

    private void createLabel ()
    {
        JPanel pnlSouth = new JPanel();
        lblMessage = new JLabel("Message");
        lblMessage.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        lblMessage.setPreferredSize(new Dimension(width, 2*height/10));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);

        pnlSouth.add(lblMessage);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    private void createButton()
    {
        JPanel pnlCenter = new JPanel();

        btnOK = new JButton("OK");
        btnOK.setPreferredSize(new Dimension(width/2, height/10));
        pnlCenter.add(btnOK); //add to panel
        add(pnlCenter, BorderLayout.CENTER);

        //add a listener
        btnOK.addActionListener(this);
     }

    private void createList()
    {
        JPanel pnlNorth = new JPanel();
        lstOutput = new JList();
        lstOutput.setPreferredSize(new Dimension ( width, 7*height/10));

        lstOutput.setForeground(Color.darkGray);
        lstOutput.setBackground(Color.lightGray);

        JScrollPane scrollPane = new JScrollPane(lstOutput);
        scrollPane.setViewportView(lstOutput);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

         pnlNorth.add(scrollPane);
         add(pnlNorth, BorderLayout.NORTH);
        //add a listener
        lstOutput.addListSelectionListener(this);
    }

   @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getSource() == lstOutput)
            controller.listPressed(lstOutput.getSelectedIndex());
    }
    //Listeners
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnOK)
            controller.okButtonPressed();
    }


    //methods called by MainFrame
    public void setMessage(String text)
    {
        lblMessage.setText(text);
    }
    public void fillListWithData(String[] items){
    lstOutput.setListData((Object[]) items);
}
}
