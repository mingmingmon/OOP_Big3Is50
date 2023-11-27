package Server.GUI;

import javax.swing.*;
import java.awt.*;

public class RankingBottomPanel extends JPanel {
    void setUp(CardLayout cards, JPanel rankingPane){
        JPanel bottomButtonPanel = new JPanel(new GridLayout(1,4));

        JButton muscleKingButton = new JButton("득근왕");
        JButton big3KingButton = new JButton("3대왕");
        JButton attendanceKingButton = new JButton("출석왕");
        JButton slimKingButton = new JButton("멸치왕");


        bottomButtonPanel.add(muscleKingButton);
        bottomButtonPanel.add(big3KingButton);
        bottomButtonPanel.add(attendanceKingButton);
        bottomButtonPanel.add(slimKingButton);

        add(bottomButtonPanel, BorderLayout.PAGE_END);

        muscleKingButton.addActionListener(e -> showPanel("득근왕", cards, rankingPane));
        big3KingButton.addActionListener(e -> showPanel("3대왕", cards, rankingPane));
        attendanceKingButton.addActionListener(e -> showPanel("출석왕", cards, rankingPane));
        slimKingButton.addActionListener(e -> showPanel("멸치왕", cards, rankingPane));
    }


    private void showPanel(String panelName, CardLayout cardPanel, JPanel rankingPane) {
        cardPanel.show((Container) rankingPane.getComponent(1), panelName);
    }
}