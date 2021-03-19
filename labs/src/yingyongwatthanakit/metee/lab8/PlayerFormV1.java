/*
  PlayerFormV1 is GUI program which
  inherit from MySimpleWindow
  additional from MySimpleWindow
  this program shows Name, Nationality
  and gender form
  Gender
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 19 March 2021
*/
package yingyongwatthanakit.metee.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV1 extends MySimpleWindow {

    protected JPanel formPanel, genderPanel;
    protected JLabel nameLabel, nationalityLabel, dobLabel, genderLabel;
    protected JTextField nameText, nationalityText, dobText;
    protected JRadioButton maleRadioButton, femaleRatioButton, othersRatioButton;
    protected ButtonGroup genderGrp;

    public PlayerFormV1(String title) {
        super(title);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        formPanel = new JPanel();
        genderPanel = new JPanel();
        nameLabel = new JLabel("Name:");
        nationalityLabel = new JLabel("Nationality:");
        dobLabel = new JLabel("Date of Birth (eg.,31-01-1990):");
        genderLabel = new JLabel("Gender:");
        nameText = new JTextField(15);
        nationalityText = new JTextField(15);
        dobText = new JTextField(15);
        maleRadioButton = new JRadioButton("Male");
        femaleRatioButton = new JRadioButton("Female", true);
        othersRatioButton = new JRadioButton("Others");
        genderGrp = new ButtonGroup();
    }

    protected void addNameThroughGender() {
        formPanel.add(nameLabel);
        formPanel.add(nameText);
        formPanel.add(nationalityLabel);
        formPanel.add(nationalityText);
        formPanel.add(dobLabel);
        formPanel.add(dobText);
        formPanel.add(genderLabel);
        formPanel.add(genderPanel);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        mainPanel.setLayout(new BorderLayout());
        // Gender Panel Add Components
        genderGrp.add(maleRadioButton);
        genderGrp.add(femaleRatioButton);
        genderGrp.add(othersRatioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRatioButton);
        genderPanel.add(othersRatioButton);

        formPanel.setLayout(new GridLayout(4, 2));
        addNameThroughGender();
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
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