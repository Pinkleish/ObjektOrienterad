package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainPanel extends JPanel implements ActionListener, ItemListener
{
    private Controller controller;
    private int width;
    private int height;

    private JLabel lblNumber1 = new JLabel("Number 1");
    private JLabel lblNumber2 = new JLabel("Number 2");
    private JLabel lblResult = new JLabel("Result");

    private JTextField txtNumber1 = new JTextField();
    private JTextField txtNumber2 = new JTextField();

    private JButton btnOK = new JButton("Calculate");

    private Font fontButtons = new Font("Arial", Font.PLAIN, 18);
    private Font fontLabels = new Font("Verdana", Font.PLAIN, 16);

    private JComboBox cmbCalcType;


    public MainPanel(Controller controller, int width, int height)
    {
        this.controller = controller;
        this.width = width;
        this.height = height;

        createComponents();
    }

    private void createComponents()
    {
        this.setPreferredSize(new Dimension(width, height/4));

        lblNumber1.setPreferredSize(new Dimension(width/8, height/14));
        lblNumber1.setFont(fontLabels);

        lblNumber2.setPreferredSize(new Dimension(width/8, height/14));
        lblNumber2.setFont(fontLabels);

        txtNumber1.setPreferredSize(new Dimension(width/8, height/14));
        txtNumber1.setHorizontalAlignment(SwingConstants.RIGHT);

        txtNumber2.setPreferredSize(new Dimension(width/8, height/14));
        txtNumber2.setHorizontalAlignment(SwingConstants.RIGHT);

        add(lblNumber1);
        add(txtNumber1);

        cmbCalcType = new JComboBox(controller.getCalcTypes());
        cmbCalcType.setSelectedIndex(0);
        add(cmbCalcType);
        cmbCalcType.addItemListener(this);

        add(lblNumber2);
        add(txtNumber2);

        //createButton();
        btnOK.setPreferredSize(new Dimension(width/6, height/14));
        btnOK.setFont(fontButtons);
        btnOK.setHorizontalAlignment(SwingConstants.CENTER);
        add(btnOK);

        lblResult.setPreferredSize(new Dimension(width, height/14));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER); //center
        lblResult.setFont(fontLabels);

        btnOK.addActionListener(this);

        add(lblResult);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        double nbr1, nbr2;
        String strNumber1, strNumber2, result;

        strNumber1 = txtNumber1.getText();
        strNumber2 = txtNumber2.getText();

        if (e.getSource() == btnOK)
        {
            controller.calculate(cmbCalcType.getSelectedIndex(), strNumber1, strNumber2);
        }
     }

     @Override
     public void itemStateChanged(ItemEvent e)
     {
         if (e.getSource() ==cmbCalcType)
         {
             controller.calcTypeChanged(cmbCalcType.getSelectedIndex());
         }
     }
     public void setResult(String result)
     {
         lblResult.setText(result);
     }

    public void setInputLabels(String strLabel1, String strLabel2)
    {
        lblNumber1.setText(strLabel1);
        lblNumber2.setText(strLabel2);

        String strToolTipText = "a/b a = täljare, b = nämnare";
        cmbCalcType.setToolTipText(strToolTipText);
        lblNumber1.setToolTipText(strToolTipText);
        lblNumber2.setToolTipText(strToolTipText);
    }
}