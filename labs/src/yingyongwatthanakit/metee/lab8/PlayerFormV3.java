/*
  PlayerFormV3 is GUI program which
  inherit from PlayerFormV2
  additional from PlayerFormV2
  this program shows additional
  display game list which contains
  "Guess Number Game", "High-Low Game"
  and "Monopoly Game"
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 19 March 2021
*/
package yingyongwatthanakit.metee.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV3 extends PlayerFormV2 {

    protected JList<String> gameList;
    protected String[] gameListStr;
    protected JLabel gameListLabel;

    @Override
    protected void initComponents() { // create GUI objects
        super.initComponents();
        gameListStr = new String[]{"Guess Number Game",
                "High-Low Game","Monopoly Game"};
        gameListLabel = new JLabel("Games");
        gameList = new JList<String>(gameListStr);
    }

    @Override
    protected void addComponents() { // add GUI objects
        super.addComponents();

        formPanel.setLayout(new GridLayout(6, 2));
        addNameThroughPlayerType();
        formPanel.add(gameListLabel);
        formPanel.add(gameList);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(notePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public PlayerFormV3(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
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
