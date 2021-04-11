/*
  GuessNumberGameWindowV2 is GUI program
  inherit from GuessNumberGameWindow in lab9
  also import GuessNumberGame in lab6
  this program is basically GuessNumberGame
  with GUI. Player can guess the number
  and when player win the winning text will display
  if player lose the losing text will display
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 9 April 2021
*/
package yingyongwatthanakit.metee.lab10;

import yingyongwatthanakit.metee.lab6.GuessNumberGame;
import yingyongwatthanakit.metee.lab9.GuessNumberGameWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumberGameWindowV2 extends GuessNumberGameWindow implements ActionListener  {

    protected GuessNumberGame gng;
    protected JButton srcBtn;
    protected int maxTries;
    protected boolean winStatus;

    public static int findIndex(JButton[] arr, JButton numberBtn)
    {
        // if array is Null
        if (arr == null) {
            return -1;
        }
        // find length of array
        int len = arr.length;
        int i = 0;
        // traverse in the array
        while (i < len) {
            // if the i-th element is t
            // then return the index
            if (arr[i] == numberBtn) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    protected void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        srcBtn = (JButton) e.getSource();
        playGameGUI();
    }

    protected void playGameGUI() {
        int playerGuess = findIndex(buttons, srcBtn) + 1;
        int correctNum = gng.getCorrectNum();
        winStatus = false;
        System.out.println(maxTries);
        if (playerGuess == correctNum) {
            resultTextField.setText("Congratulations!!!");
            resultTextField.setEnabled(false);
            disableButtons();
            winStatus = true;
        } else if (playerGuess > correctNum) {
            resultTextField.setText("Lower");
            maxTries--;
        } else {
            resultTextField.setText("Higher");
            maxTries--;
        }
        if (!winStatus && maxTries == 0) {
            resultTextField.setText("No more tries");
            resultTextField.setEnabled(false);
            disableButtons();
        }
    }


    @Override
    protected void initComponents() {
        super.initComponents();
        resultTextField.setText("");
        gng = new GuessNumberGame(1, 10, 3);
        maxTries = gng.getMaxTries();
        addListeners();
    }

    protected void addListeners() {
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
    }

    public GuessNumberGameWindowV2(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        GuessNumberGameWindowV2 window = new GuessNumberGameWindowV2("GuessNumberGameWindow Version 1");
        window.addComponents();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessNumberGameWindowV2::createAndShowGUI);
    }

}
