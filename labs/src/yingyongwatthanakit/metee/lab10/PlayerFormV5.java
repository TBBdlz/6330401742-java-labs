/*
  PlayerFormV5 is GUI program
  inherit from PlayerFormV4 in lab8
  which implement ActionListener
  now player can enter form and
  interact with button, text field
  and JComboBox
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 9 April 2021
*/
package yingyongwatthanakit.metee.lab10;

import yingyongwatthanakit.metee.lab8.PlayerFormV4;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("rawtypes")
public class PlayerFormV5 extends PlayerFormV4 implements ActionListener {
    protected String nameStr, nationalityStr
            , birthdate, genderStr, playerTypeStr;
    protected Object srcObj;
    protected JButton srcBtn;
    protected JTextField srcTf;
    protected JComboBox srcComboBox;

    public PlayerFormV5(String title) {
        super(title);
    }

    protected void getGender() {
        if (maleRadioButton.isSelected()) {
            genderStr = maleRadioButton.getText();
        } else if (femaleRatioButton.isSelected()) {
            genderStr = femaleRatioButton.getText();
        } else if (othersRatioButton.isSelected()) {
            genderStr = othersRatioButton.getText();
        }
    }

    protected void handleSubmitButton() {
        nameStr = nameText.getText();
        nationalityStr = nationalityText.getText();
        birthdate = dobText.getText();
        getGender();
        playerTypeStr = (String) playerTypeBox.getSelectedItem();
        StringBuffer res = new StringBuffer();
        res.append(nameStr).append(" has nationality as ").append(nationalityStr);
        res.append(", birthdate as ").append(birthdate);
        res.append(", gender as ").append(genderStr);
        res.append(", player type as ").append(playerTypeStr);
        JOptionPane.showMessageDialog(this, res);
    }

    protected void clearData() {
        nameText.setText("");
        nationalityText.setText("");
        dobText.setText("");
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        addListeners();
    }

    protected void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameText.addActionListener(this);
        nationalityText.addActionListener(this);
        dobText.addActionListener(this);
        playerTypeBox.addActionListener(this);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void actionPerformed(ActionEvent e) {
        srcObj = e.getSource();
        if (srcObj instanceof JButton) {
            srcBtn = (JButton) srcObj;
            if (srcBtn == submitButton) {
                handleSubmitButton();
            } else if (srcBtn == resetButton) {
                clearData();
            }
        }
        if (srcObj instanceof JTextField) {
            srcTf = (JTextField) srcObj;
            handleTextField(srcTf);
        }
        if (srcObj instanceof JComboBox) {
            srcComboBox = (JComboBox) srcObj;
            if (srcComboBox == playerTypeBox) {
                String res = "Player type is updated to " +
                        srcComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(this, res);
            }
        }
    }

    protected void handleTextField(JTextField tf) {
        String res = "";
        if (tf == nameText) {
            res = "Name is updated to " + nameText.getText();
        } else if (tf == nationalityText) {
            res = "Nationality is updated to " + nationalityText.getText();
        } else if (tf == dobText) {
            res = "Date of birth is updated to " + dobText.getText();
        }
        JOptionPane.showMessageDialog(this, res);
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerFormV5::createAndShowGUI);
    }

}
