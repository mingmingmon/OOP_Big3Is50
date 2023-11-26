package Server.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProgramDetailPage extends JPanel {
    private JLabel titleLabel;

    void setup(String panelName, CardLayout programCards, JPanel cardPanel){
        setLayout(new BorderLayout());

        titleLabel = new JLabel(panelName);
        add(titleLabel, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭되었을 때 다른 화면으로 이동
                //showPanel(detailPageName, programCards, programPane);
                programCards.show(cardPanel, "프로그램 메인화면");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // 마우스가 패널에 들어왔을 때의 동작
                ProgramDetailPage.this.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 마우스가 패널을 벗어났을 때의 동작
                ProgramDetailPage.this.setBackground(null); // 기본 색상으로 돌아가기
            }

        });
    }
}
