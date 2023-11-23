package Server.GUI;

import javax.swing.*;
import java.awt.*;

public class RankingCardPanel extends JPanel{
    void setUp(JPanel cardPanel){
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


/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingExample {
    private JPanel rankingPane;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RankingExample example = new RankingExample();
            example.setUpRankingPane();
            example.createAndShowGUI();
        });
    }

    private void setUpRankingPane() {
        JButton muscleKingButton = new JButton("득근왕");
        JButton big3KingButton = new JButton("3대왕");
        JButton attendanceKingButton = new JButton("출석왕");
        JButton slimKingButton = new JButton("멸치왕");

        // 각 버튼에 대한 이벤트 리스너 추가
        muscleKingButton.addActionListener(e -> showPanel("득근왕"));
        big3KingButton.addActionListener(e -> showPanel("3대왕"));
        attendanceKingButton.addActionListener(e -> showPanel("출석왕"));
        slimKingButton.addActionListener(e -> showPanel("멸치왕"));

        rankingPane = new JPanel(new BorderLayout());

        // 각 버튼을 담을 패널
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(muscleKingButton);
        buttonPanel.add(big3KingButton);
        buttonPanel.add(attendanceKingButton);
        buttonPanel.add(slimKingButton);

        rankingPane.add(buttonPanel, BorderLayout.SOUTH);

        // CardLayout을 이용하여 각 랭킹 패널을 추가
        cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // 각 랭킹 패널 생성 및 추가
        JPanel muscleKingPanel = createRankingPanel("득근왕");
        JPanel big3KingPanel = createRankingPanel("3대왕");
        JPanel attendanceKingPanel = createRankingPanel("출석왕");
        JPanel slimKingPanel = createRankingPanel("멸치왕");

        cardPanel.add(muscleKingPanel, "득근왕");
        cardPanel.add(big3KingPanel, "3대왕");
        cardPanel.add(attendanceKingPanel, "출석왕");
        cardPanel.add(slimKingPanel, "멸치왕");

        rankingPane.add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createRankingPanel(String ranking) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(ranking));
        // 여기에 각 랭킹 별로 내용을 추가할 수 있습니다.
        return panel;
    }

    private void showPanel(String panelName) {
        cardLayout.show(rankingPane.getComponent(1), panelName);
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Ranking Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(rankingPane);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
*/