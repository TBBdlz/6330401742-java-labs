package yingyongwatthanakit.metee.lab11;

import yingyongwatthanakit.metee.lab10.PlayerFormV8;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PlayerFormV9 extends PlayerFormV8 implements ActionListener {

    protected String emptyStr, dobFormatStr;
    protected Object checkList;
    public PlayerFormV9(String title) {
        super(title);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        emptyStr = "";
        dobFormatStr = "";
    }


    protected void checkEmptyTextField() {
        emptyStr = "";
        boolean isNameEmpty = nameText.getText().isEmpty();
        boolean isNationalityEmpty = nationalityText.getText().isEmpty();
        boolean isDobEmpty = dobText.getText().isEmpty();
        boolean isEmpty = false;
        if (isNameEmpty) {
            emptyStr += "Name is empty\n";
            isEmpty = true;
        }
        if (isNationalityEmpty) {
            emptyStr += "Nationality is empty\n";
            isEmpty = true;
        }
        if (isDobEmpty) {
            emptyStr += "Birthdate is empty\n";
            isEmpty = true;
        }
        if (isEmpty) {
            throw new RuntimeException(emptyStr.trim());
        }
    }

    protected void checkBirthDateFormat() {
        String timePattern = "dd-MM-yyyy";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
        LocalDate parsed = LocalDate.parse(dobText.getText(), timeFormatter);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (srcBtn == submitButton || srcObj instanceof JTextField ||
        srcObj instanceof JCheckBox) {
            try {
                checkEmptyTextField();
                checkBirthDateFormat();
                if (lsm.isSelectionEmpty()) {
                    throw new RuntimeException("You have not selected any game");
                }
                super.actionPerformed(evt);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this
                        , "Please enter date in format dd-MM-yyyy such as 31-02-2021");
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            super.actionPerformed(evt);
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerFormV9::createAndShowGUI);
    }

}
