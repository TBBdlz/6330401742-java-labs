/*
  PlayerFormV8 is GUI program
  this program implement ActionListener
  the program add mnemonic key
  and accelerator key to menu item
  player now can interact with menu item
  and setting form
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 9 April 2021
*/
package yingyongwatthanakit.metee.lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class PlayerFormV8 extends PlayerFormV7 implements ActionListener {

    protected JFileChooser fileChooser, fileSave;
    protected JMenuItem srcMenuItem;
    protected File file;

    public PlayerFormV8(String title) {
        super(title);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        addMnemonicsAndAccelerator();
        file = new File("/Users/tbbddl/6330401742-java-labs/labs/src/yingyongwatthanakit");
    }

    protected void addMnemonicsAndAccelerator() {
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        exitItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        colorMenu.addActionListener(this);
        sizeMenu.addActionListener(this);
        // size of color sub menu is equal to size of size sub menu
        int sizeColor = colorMenu.getItemCount();
        for (int i = 0; i < sizeColor; i++) {
            colorMenu.getItem(i).addActionListener(this);
            sizeMenu.getItem(i).addActionListener(this);
        }
    }

    protected Color getColor(String colorStr) {
        return switch (colorStr) {
            case "WHITE" -> Color.WHITE;
            case "PINK" -> Color.PINK;
            case "BLACK" -> Color.BLACK;
            default -> null;
        };
    }

    protected void handleSaveMI() {
        fileSave = new JFileChooser();
        int option = fileSave.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = fileSave.getSelectedFile();
            JOptionPane.showMessageDialog(this, "File saved: " + file.getName());
        } else if (option == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "save command cancelled by user");
        }
    }

    protected void handleConfigMI() {
        int size = colorMenu.getItemCount();
        for (int i = 0; i < size; i++) {
            if (srcMenuItem == colorMenu.getItem(i)) {
                Color color = getColor(colorMenu.getItem(i).getText());
                nameText.setForeground(color);
                nationalityText.setForeground(color);
                dobText.setForeground(color);
            } else if (srcMenuItem == sizeMenu.getItem(i)) {
                float fontSize = Float.parseFloat(sizeMenu.getItem(i).getText());
                noteTextArea.setFont(noteTextArea.getFont().deriveFont(fontSize));
            }
        }
    }

    protected void handleOpenMI() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "File selected: " + file.getName());
        } else if (option == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Open command cancelled by user");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (srcObj instanceof JMenuItem) {
            srcMenuItem = (JMenuItem) srcObj;
            if (srcMenuItem == openItem) {
                handleOpenMI();
            } else if (srcMenuItem == exitItem) {
                System.exit(0);
            } else if (srcMenuItem == saveItem) {
                handleSaveMI();
            } else {
                handleConfigMI();
            }
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerFormV8::createAndShowGUI);
    }

}
