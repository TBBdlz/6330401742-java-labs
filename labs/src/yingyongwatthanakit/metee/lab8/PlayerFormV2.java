/*
  PlayerFormV2 is GUI program which
  inherit from PlayerFormV1
  additional from PlayerFormV1
  this program shows additional
  playerType Combo Box which has
  "Beginner", "Amateur", "Professional" in
  playerType Combo Box
  and PlayerFormV2 also display note
  panel contains note for games
  Gender
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 19 March 2021
*/
package yingyongwatthanakit.metee.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV2 extends PlayerFormV1 {

    protected JScrollPane noteScrollPane;
    protected JPanel notePanel;
    protected JLabel playerTypeLabel, noteLabel;
    protected JTextArea noteTextArea;
    protected JComboBox<String> playerTypeBox;
    protected String[] playerTypeStr;

    @Override
    protected void initComponents() { // create GUI objects
        super.initComponents();
        notePanel = new JPanel();
        playerTypeLabel = new JLabel("Player Type:");
        noteLabel = new JLabel("Note:");
        noteTextArea = new JTextArea(3, 35);
        noteScrollPane = new JScrollPane(noteTextArea);
        noteScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);
        noteTextArea.setText("A game is a structured form of play, usually undertaken for\n");
        noteTextArea.append("entertainment or fun, and sometimes used as an educational tool.");
        playerTypeStr = new String[]{"Beginner", "Amateur", "Professional"};
        playerTypeBox = new JComboBox<String>(playerTypeStr);
        playerTypeBox.setSelectedIndex(1);
    }

    protected void addNameThroughPlayerType() { // add name, nationality, gender and player type to form panel
        addNameThroughGender();
        formPanel.add(playerTypeLabel);
        formPanel.add(playerTypeBox);
    }

    @Override
    protected void addComponents() { // add GUI objects
        super.addComponents();
        formPanel.setLayout(new GridLayout(5, 2));
    
        // set up notePanel
        notePanel.setLayout(new BorderLayout());
        notePanel.add(noteLabel, BorderLayout.NORTH);
        notePanel.add(noteScrollPane, BorderLayout.SOUTH);

        addNameThroughPlayerType();
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(notePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public PlayerFormV2(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
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
