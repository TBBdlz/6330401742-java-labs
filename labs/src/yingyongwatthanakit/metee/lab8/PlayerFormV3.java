package yingyongwatthanakit.metee.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV3 extends PlayerFormV2 {

    protected JList<String> gameList;
    protected String[] gameListStr;
    protected JLabel gameListLabel;

    @Override
    public void initComponents() {
        super.initComponents();
        gameListStr = new String[]{"Guess Number Game",
                "High-Low Game","Monopoly Game"};
        gameListLabel = new JLabel("Games");
        gameList = new JList<String>(gameListStr);
    }

    @Override
    public void addComponents() {
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
