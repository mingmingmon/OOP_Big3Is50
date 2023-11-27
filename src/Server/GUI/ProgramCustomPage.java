package Server.GUI;

import Server.Program;
import Server.ServerComputer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ProgramCustomPage extends JPanel {
    private JLabel imageLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel dateLabel;

    static String week = "월화수목금토일";
    boolean[] isWorking;
    private StringBuilder workingDate;

    ArrayList<Program> programList;

    public ProgramCustomPage(String title, CardLayout programCards, JPanel cardPanel){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350,150));

        String imagePath = ServerComputer.getAbsolutePath("data\\program-image\\" + title + ".png");
        if(!new File(imagePath).exists())
            imagePath = ServerComputer.getAbsolutePath("data\\program-image\\no image.png");
        Image image = new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(image));
        add(imageLabel, BorderLayout.LINE_START);

        titleLabel = new JLabel(title);
        add(titleLabel);

        descriptionLabel = new JLabel(title + "입니다");
        add(descriptionLabel, BorderLayout.LINE_END);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭되었을 때 다른 화면으로 이동
                //showPanel(detailPageName, programCards, programPane);
                programCards.show(cardPanel, title);
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
        // addMouseListener((MouseListener) this);

        programList = new ArrayList<>();
        isWorking = new boolean[7];
        workingDate = new StringBuilder();
    }
    public void add(Program program) {
        programList.add(program);

        for (int i = 0; i < 7; i++) {
            if (program.date.contentEquals(week.charAt(i) + "") && !isWorking[i]) {
                isWorking[i] = true;
                workingDate.append(week.charAt(i) + " ");
                break;
            }
        }
        dateLabel = new JLabel(workingDate.toString());
        add(dateLabel, BorderLayout.SOUTH);


    }

   /* private class PanelClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 패널이 클릭되었을 때 수행할 동작을 여기에 작성
            cardPanel.show((Container) rankingPane.getComponent(1), panelName);
            //JOptionPane.showMessageDialog(null, "패널이 클릭되었습니다!");
        }
    }*/

    private void showPanel(String panelName, CardLayout cardPanel, JPanel rankingPane) {
        cardPanel.show((Container) rankingPane.getComponent(1), panelName);
    }
}
