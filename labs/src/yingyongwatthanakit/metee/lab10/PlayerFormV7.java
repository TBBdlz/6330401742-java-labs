package yingyongwatthanakit.metee.lab10;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class PlayerFormV7 extends PlayerFormV6 implements ListSelectionListener {

    protected ListSelectionModel lsm;

    public PlayerFormV7(String title) {
        super(title);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        gameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lsm = gameList.getSelectionModel();
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        lsm.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        boolean isAdjusting = e.getValueIsAdjusting();
        if (!isAdjusting) {
            String message;
            List<String> selectedGames = gameList.getSelectedValuesList();
            message = String.join(", ", selectedGames);
            JOptionPane.showMessageDialog(this, message);
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerFormV7::createAndShowGUI);
    }

}
