package yingyongwatthanakit.metee.lab11;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class PlayerFormV10 extends PlayerFormV9 {

    protected BufferedReader bufferedReader;
    protected BufferedWriter bufferedWriter;
    protected int[] gameIndices = {-1, -1, -1};

    public PlayerFormV10(String title) {
        super(title);
    }

    protected void setInputAsSelectedGame(String inputTxt) {
        switch (inputTxt) {
            case "guess number game" -> gameList.setSelectedIndex(0);
            case "high-low game" -> gameList.setSelectedIndex(1);
            case "monopoly game" -> gameList.setSelectedIndex(2);
        }
    }

    protected void setPlayerType(String inputTxt) {
        switch (inputTxt) {
            case "beginner" -> gameIndices[0] = 1;
            case "amateur" -> gameIndices[1] = 1;
            case "professional" -> gameIndices[2] = 1;
        }
    }

    protected void setGender(String inputTxt) {
        switch (inputTxt) {
            case "male" -> maleRadioButton.setSelected(true);
            case "female" -> femaleRatioButton.setSelected(true);
            case "others" -> othersRatioButton.setSelected(true);
        }
    }
    @Override
    protected void handleOpenMI() {
        try {
            super.handleOpenMI();
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            nameText.setText(bufferedReader.readLine());
            nationalityText.setText(bufferedReader.readLine());
            dobText.setText(bufferedReader.readLine());
            String inputText;
            int i = 1;
            while ((inputText = bufferedReader.readLine()) != null) {
                if (i == 1) {
                    setGender(inputText);
                    i++;
                } else if (i == 2) {
                    setPlayerType(inputText);
                    i++;
                } else {
                    setInputAsSelectedGame(inputText);
                }
            }
            gameList.setSelectedIndices(gameIndices);
        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    protected void handleSaveMI() {
        try {
            super.handleSaveMI();
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(nameText.getText() + "\n");
            bufferedWriter.write(nationalityText.getText() + "\n");
            bufferedWriter.write(dobText.getText() + "\n");
            bufferedWriter.write(genderStr + "\n");
            bufferedWriter.write(playerTypeStr + "\n");
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerFormV10::createAndShowGUI);
    }

}
