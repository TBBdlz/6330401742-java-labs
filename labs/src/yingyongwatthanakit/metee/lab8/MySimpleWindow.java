/*
  MySimpleWindow is GUI java program
  this program inherit from JFrame
  create simple button "Reset" and "Submit"
  set frame features and create GUI to the screen
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 19 March 2021
*/
package yingyongwatthanakit.metee.lab8;

import javax.swing.*;
import java.awt.*;

public class MySimpleWindow extends JFrame {

     protected JPanel mainPanel, buttonPanel;
     protected JButton resetButton, submitButton;

    public MySimpleWindow(String title) {
        super(title);
    }

    protected void initComponents() {
        mainPanel = (JPanel) this.getContentPane();
        buttonPanel = new JPanel();
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
    }

     protected void addComponents() {
         initComponents();
         buttonPanel.add(resetButton);
         buttonPanel.add(submitButton);
         mainPanel.add(buttonPanel);
     }

     protected void setFrameFeatures() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

     public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
     }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
