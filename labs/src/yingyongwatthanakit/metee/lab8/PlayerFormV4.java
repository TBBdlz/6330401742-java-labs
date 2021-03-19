/*
  PlayerFormV4 is GUI program which
  inherit from PlayerFormV3
  additional from PlayerFormV3
  this program add menu         bar
  which has file menu
  and config menu
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 19 March 2021
*/
package yingyongwatthanakit.metee.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {

    protected JMenuBar menu;
    protected JMenu fileMenu, configMenu, colorMenu, sizeMenu;
    protected JMenuItem newItem, openItem, saveItem, exitItem;
    protected ImageIcon newImg, openImg, saveImg;

    @Override
    public void initComponents() {
        super.initComponents();
        newImg = new ImageIcon("images/New-file-icon.png");
        openImg = new ImageIcon("images/folder-open-icon.png");
        saveImg = new ImageIcon("images/save_icon.png");
        menu = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        newItem = new JMenuItem("New", newImg);
        openItem = new JMenuItem("Open", openImg);
        saveItem = new JMenuItem("Save", saveImg);
        exitItem = new JMenuItem("Exit");
        colorMenu = new JMenu("Color");
        colorMenu.add(new JMenuItem("BLACK"));
        colorMenu.add(new JMenuItem("PINK"));
        colorMenu.add(new JMenuItem("WHITE"));
        sizeMenu = new JMenu("Size");
        sizeMenu.add(new JMenuItem("16"));
        sizeMenu.add(new JMenuItem("20"));
        sizeMenu.add(new JMenuItem("24"));
    }

    @Override
    public void addComponents() {
        super.addComponents();
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        configMenu.add(colorMenu);
        configMenu.add(sizeMenu);
        menu.add(fileMenu);
        menu.add(configMenu);
        this.setJMenuBar(menu);
    }

    public PlayerFormV4(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
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
