package Server.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramCustomPage extends JPanel {
    private JLabel imageLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;

    public ProgramCustomPage(String image, String title, String description, String detailPageName, CardLayout programCards, JPanel cardPanel){
        setLayout(new BorderLayout());

        imageLabel = new JLabel(image);
        add(imageLabel, BorderLayout.LINE_START);

        titleLabel = new JLabel(title);
        add(titleLabel, BorderLayout.CENTER);

        descriptionLabel = new JLabel(description);
        add(descriptionLabel, BorderLayout.LINE_END);

        setPreferredSize(new Dimension(400,200));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭되었을 때 다른 화면으로 이동
                //showPanel(detailPageName, programCards, programPane);
                programCards.show(cardPanel, detailPageName);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // 마우스가 패널에 들어왔을 때의 동작
                ProgramCustomPage.this.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 마우스가 패널을 벗어났을 때의 동작
                ProgramCustomPage.this.setBackground(null); // 기본 색상으로 돌아가기
            }
        });
    }
}
