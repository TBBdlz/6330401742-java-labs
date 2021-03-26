package yingyongwatthanakit.metee.lab9;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GuessNumberGameWindow extends JFrame {

    protected Font commonFont;
    protected JButton button1, button2, button3, button4
                    , button5, button6, button7, button8
                    , button9, button10;
    protected JLabel headerLabel, resultLabel;
    protected JTextField resultTextField;
    protected JButton[] buttons;
    protected String[] imageIconName;
    protected JPanel mainPanel, headerPanel, buttonsPanel, resultPanel;

    public GuessNumberGameWindow(String title) {
        super(title);
    }

    protected void initComponents() {
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        buttons = new JButton[] {
                button1, button2, button3, button4, button5
                , button6, button7, button8, button9, button10
        };
        imageIconName  = new String[] {
                "number1", "number2", "number3", "number4", "number5"
                , "number6", "number7", "number8", "number9", "number10"
        };
        try {
            for (int i = 0; i < buttons.length; i++) {
                Icon icon = new ImageIcon("images/" + imageIconName[i] + ".png");
                buttons[i].setIcon(icon);
            }
        } catch (Exception e) { // catch error eg. null exception
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        commonFont = new Font("Serif", Font.BOLD, 24);
        headerLabel = new JLabel("Please guess by clicking at the number:");
        headerLabel.setFont(commonFont);
        headerLabel.setForeground(Color.BLUE);
        resultLabel = new JLabel("Result");
        resultLabel.setFont(commonFont);
        resultLabel.setForeground(Color.BLUE);
        resultTextField = new JTextField("Congratulations!", 20);
        resultTextField.setFont(commonFont);
        resultTextField.setForeground(Color.GRAY);
        resultTextField.setEnabled(false);
        mainPanel = (JPanel) this.getContentPane();
        headerPanel = new JPanel();
        resultPanel = new JPanel();
        buttonsPanel = new JPanel();

    }

    protected void addComponents() {
        initComponents();
        buttonsPanel.setLayout(new GridLayout(2, 5));
        for (JButton button : buttons) {
            buttonsPanel.add(button);
        }
        headerPanel.add(headerLabel);
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(resultLabel);
        resultPanel.add(resultTextField);
        resultPanel.add(resultTextField);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
    }

    protected void setFrameFeatures() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(700, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
    }

    public static void createAndShowGUI() {
        GuessNumberGameWindow window = new GuessNumberGameWindow("GuessNumberGameWindow Version 1");
        window.addComponents();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessNumberGameWindow::createAndShowGUI);
    }

}