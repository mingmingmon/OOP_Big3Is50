package Server.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeCardPage extends JPanel {
    void setup(String cardName,JPanel cardPanel, CardLayout homeCards){
        Font middleFont = new Font("맑은 고딕", Font.BOLD, 25);
        Font bigFont = new Font("맑은 고딕", Font.BOLD, 40);
        setLayout(new BorderLayout());
        JLabel cardNameLabel = new JLabel(cardName, SwingConstants.CENTER);
        cardNameLabel.setPreferredSize(new Dimension(500,50));
        cardNameLabel.setOpaque(true);
        cardNameLabel.setBackground(Color.GRAY);
        cardNameLabel.setForeground(Color.BLACK);
        cardNameLabel.setFont(bigFont);

        JPanel dataPanel = new JPanel();
        //테이블 만들어서 거기 안에 정보 넣어주기 + 검색 가능하게.

        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        //dataPanel.setPreferredSize(new Dimension(650, 200 * 10));

        for (int i = 1; i <= 20; i++) {
            JLabel label = new JLabel("Asdf", SwingConstants.CENTER);
            //label.setPreferredSize(new Dimension(400,50));
            label.setFont(bigFont);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);//이거 없으면 boxlayout때문에 가운데 정렬이 안돼.
            dataPanel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(dataPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 비활성화
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel buttonPanel = new JPanel();

        JButton goBackButton = new JButton("뒤로가기");
        goBackButton.setFont(middleFont);
        goBackButton.setPreferredSize(new Dimension(150,70));
        goBackButton.setBackground(Color.BLACK);
        goBackButton.setForeground(Color.WHITE);
        goBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeCards.show(cardPanel, "홈 화면");
            }
        });
        buttonPanel.add(goBackButton);

        add(cardNameLabel, BorderLayout.NORTH);
        // Jtable 만들어서 add
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
