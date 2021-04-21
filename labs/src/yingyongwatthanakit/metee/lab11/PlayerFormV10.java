/*
  PlayerFormV10 is GUI program
  now program can read text file
  and updates data within the file
  the program also can save file now
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 16 April 2021
*/
package yingyongwatthanakit.metee.lab11;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class PlayerFormV10 extends PlayerFormV9 {

    protected BufferedReader bufferedReader;
    protected BufferedWriter bufferedWriter;
    protected int[] gameIndices = new int[3];

    public PlayerFormV10(String title) {
        super(title);
    }

    protected void setInputAsSelectedGame(String inputTxt) {
        if (inputTxt.equalsIgnoreCase("guess number game")) {
            gameIndices[0] = 0;
        }
        if (inputTxt.equalsIgnoreCase("high-low game")) {
            gameIndices[1] = 1;
        }
        if (inputTxt.equalsIgnoreCase("monopoly game")) {
            gameIndices[2] = 2;
        }
    }

    protected void setPlayerType(String inputTxt) {
        switch (inputTxt) {
            case "beginner" -> playerTypeBox.setSelectedIndex(0);
            case "amateur" -> playerTypeBox.setSelectedIndex(1);
            case "professional" -> playerTypeBox.setSelectedIndex(2);
        }
    }

    protected void clearIndices() {
        gameIndices[0] = -1;
        gameIndices[1] = -1;
        gameIndices[2] = -1;
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
            FileReader fileReader = new FileReader(file.getName());
            bufferedReader = new BufferedReader(fileReader);
            String inputText;
            int i = 1;
            while ((inputText = bufferedReader.readLine()) != null) {
                if (i == 1) {
                    nameText.setText(inputText);
                } else if (i == 2) {
                    nationalityText.setText(inputText);
                } else if (i == 3) {
                    dobText.setText(inputText);
                } else if (i == 4) {
                    setGender(inputText);
                } else if (i == 5) {
                    setPlayerType(inputText);

                } else {
                    setInputAsSelectedGame(inputText);
                }
                i++;
            }
            gameList.setSelectedIndices(gameIndices);
            clearIndices();
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
            getGender();
            bufferedWriter.write(genderStr + "\n");
            bufferedWriter.write(playerTypeBox.getSelectedItem() + "\n");
            List<String> selectedGames = gameList.getSelectedValuesList();
            String allSelectedGames = String.join("\n", selectedGames);
            bufferedWriter.write(allSelectedGames);
            bufferedWriter.close();
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
