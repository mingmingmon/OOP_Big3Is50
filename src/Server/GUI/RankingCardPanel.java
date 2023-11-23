package Server.GUI;

import javax.swing.*;
import java.awt.*;

public class RankingCardPanel extends JPanel{
    void setup(JPanel cardPanel){
        JPanel muscleKingPanel = createRankingPanel("득근왕");
        JPanel big3KingPanel = createRankingPanel("3대왕");
        JPanel attendanceKingPanel = createRankingPanel("출석왕");
        JPanel slimKingPanel = createRankingPanel("멸치왕");

        cardPanel.add(muscleKingPanel, "득근왕");
        cardPanel.add(big3KingPanel, "3대왕");
        cardPanel.add(attendanceKingPanel, "출석왕");
        cardPanel.add(slimKingPanel, "멸치왕");

        //add(cardPanel, BorderLayout.CENTER);

        //return cardPanel;
    }

    private JPanel createRankingPanel(String rankingName) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(rankingName);
        //label.setForeground(Color.WHITE); // 텍스트 색상을 흰색으로 설정
        panel.add(label);
        // 여기에 각 랭킹 별로 내용을 추가할 수 있습니다.
        return panel;
    }
}