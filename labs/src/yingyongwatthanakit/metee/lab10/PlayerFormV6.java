/*
  PlayerFormV6 is GUI program
  this program implement ItemListener
  which can interact with JRadioButton
  use for gender Radio Button
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 9 April 2021
*/
package yingyongwatthanakit.metee.lab10;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PlayerFormV6 extends PlayerFormV5 implements ItemListener {

    public PlayerFormV6(String title) {
        super(title);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        maleRadioButton.addItemListener(this);
        femaleRatioButton.addItemListener(this);
        othersRatioButton.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object srcObj = e.getSource();
        JRadioButton srcRadioBtn = (JRadioButton) srcObj;
        String updateTxt = "Gender is updated to ";
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, updateTxt + srcRadioBtn.getText());
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerFormV6::createAndShowGUI);
    }

}
