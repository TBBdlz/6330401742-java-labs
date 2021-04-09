package yingyongwatthanakit.metee.lab10;

import yingyongwatthanakit.metee.lab6.GuessNumberGame;
import yingyongwatthanakit.metee.lab9.GuessNumberGameWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumberGameWindowV2 extends GuessNumberGameWindow implements ActionListener  {

    protected GuessNumberGame gng;
    protected JButton srcBtn;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        srcBtn = (JButton) e.getSource();
        playGameGUI();
    }

    protected void playGameGUI() {
        int playerGuess = findIndex(buttons, srcBtn) + 1;
        int correctNum = gng.getCorrectNum();
        int maxTries = gng.getMaxTries();
        for (int i = 0; i < maxTries; i++) {
            if (playerGuess == correctNum) {
                resultTextField.setText("Congratulations!!!");
                resultTextField.setVisible(true);
            } else if (playerGuess > correctNum) {
                resultTextField.setText("Lower");
                maxTries--;
            } else {
                resultTextField.setText("Higher");
                maxTries--;
            }
        }
    }


    @Override
    protected void initComponents() {
        super.initComponents();
        resultTextField.setText("");
        gng = new GuessNumberGame(1, 10, 3);
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
