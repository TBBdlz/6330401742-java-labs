package yingyongwatthanakit.metee.lab9;

import yingyongwatthanakit.metee.lab6.DiceGame;
import javax.swing.*;
import java.awt.*;

public class DiceImageWindow extends JFrame {

    protected int diceRoll;
    protected DiceImageCanvas diceImageCanvas;
    protected DiceGame diceGame;
    protected JPanel mainPanel, buttonsPanel;
    protected JButton highButton, lowButton, rollButton;

    public DiceImageWindow(String title) {
        super(title);
        diceGame = new DiceGame();
        diceRoll = diceGame.getDiceRoll();
        diceImageCanvas = new DiceImageCanvas(diceRoll);
    }

    protected void initComponents() {
        mainPanel = diceImageCanvas;
        highButton = new JButton("HIGH");
        lowButton = new JButton("LOW");
        rollButton = new JButton("ROLL");
        buttonsPanel = new JPanel();
    }

    protected void addComponents() {
        initComponents();
        buttonsPanel.add(highButton);
        buttonsPanel.add(lowButton);
        buttonsPanel.add(rollButton);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
    }

    protected void setFrameFeatures() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
    }

    public static void createAndShowGUI() {
        DiceImageWindow window = new DiceImageWindow("DiceGameWindow Version 1");
        window.addComponents();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DiceImageWindow::createAndShowGUI);
    }

}