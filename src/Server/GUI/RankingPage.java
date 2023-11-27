package Server.GUI;

import Server.ServerComputer;

import javax.swing.*;
import java.awt.*;

public class RankingPage extends JPanel{
    //JPanel rankingPanel;
    JLabel rankingLabel;
    void setup(String rankingName){
        setLayout(new BorderLayout());
        Font font = new Font("맑은 고딕", Font.PLAIN, 15);
        Font middleFont = new Font("맑은 고딕", Font.BOLD, 20);
        Font bigFont = new Font("맑은 고딕", Font.BOLD, 25);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel imageLabel = new JLabel();
        String imagePath = ServerComputer.getAbsolutePath("data\\ranking-image\\" + rankingName + ".png");
        Image image = new ImageIcon(imagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));

        JLabel trophyImageLabel = new JLabel();
        String trophyImagePath = ServerComputer.getAbsolutePath("data\\ranking-image\\트로피.png");
        Image trophyImage = new ImageIcon(trophyImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        trophyImageLabel.setIcon(new ImageIcon(trophyImage));

        rankingLabel = new JLabel(rankingName, SwingConstants.CENTER);
        rankingLabel.setPreferredSize(new Dimension(340,50));
        rankingLabel.setOpaque(true); // 배경 불투명하게 해야 배경색 보임
        rankingLabel.setBackground(Color.ORANGE);
        rankingLabel.setForeground(Color.BLACK);
        rankingLabel.setFont(bigFont);

        JPanel midPanel = new JPanel(new GridLayout(5,1));
        for (int i = 0; i < 5; i++) {
            JPanel personPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,30));
            JLabel personImageLabel = new JLabel();
            //각 랭킹별로 아이디가 제목인 이미지 파일 불러옴.
            String personImagePath = ServerComputer.getAbsolutePath("data\\user-image\\kimEgg.png");
            Image personImage = new ImageIcon(personImagePath).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
            personImageLabel.setIcon(new ImageIcon(personImage));

            personPanel.add(personImageLabel);

            //알맞은 이름으로 수정필요.
            JLabel name = new JLabel("김계란", SwingConstants.CENTER);
            name.setFont(bigFont);

            personPanel.add(name);

            //알맞은 기록으로 수정필요.
            JLabel spec = new JLabel("100kg", SwingConstants.CENTER);
            spec.setFont(bigFont);

            personPanel.add(spec);

            //알맞은 그림으로 수정필요.-->지윤님이 이미지 파일 주면 가능.
            JLabel medalImageLabel = new JLabel();
            String medalImagePath = ServerComputer.getAbsolutePath("data\\ranking-image\\" + (i + 1) + ".png");
            Image medalImage = new ImageIcon(medalImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
            medalImageLabel.setIcon(new ImageIcon(medalImage));

            personPanel.add(medalImageLabel);

            midPanel.add(personPanel);
        }


        topPanel.add(trophyImageLabel);
        topPanel.add(rankingLabel);
        topPanel.add(imageLabel);

        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);

    }





}
