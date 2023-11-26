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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭되었을 때 다른 화면으로 이동
                //showPanel(detailPageName, programCards, programPane);
                programCards.show(cardPanel, detailPageName);
            }
        });
    }
}
