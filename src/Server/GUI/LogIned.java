package Server.GUI;

import javax.swing.*;
import java.awt.*;

class LogIned extends JPanel {
    void createAndShowGUI(JPanel cardPanel/*, CardLayout startCards*/) {
        // 탭을 생성하고 home, ranking, program, trainer, myPage 총 5개 패널 추가
        JTabbedPane topTab = new JTabbedPane();

        setupHomePane();
        setupRankingPane();
        setupProgramPane();
        setupTrainerPane();
        setupMyPagePane();

        topTab.add("홈", homePane);
        topTab.add("랭킹", rankingPane);
        topTab.add("프로그램", programPane);
        topTab.add("트레이너", trainerPane);
        topTab.add("마이페이지", myPagePane);

        cardPanel.add(topTab, "로그인후 페이지");
    }

    private JPanel homePane;
    private void setupHomePane(){
        // 홈화면은 맨 위에 home이라는 글자 있는 배너 (JLabel)
        // 중간에 사진이랑 이름, 운동 몇 일 째 정보 하나의 pane
        // 나의 인바디, 나의 운동기록 임티랑 글씨 하나의 pane
        // 체중, 운동기록, 골격근량, 나의 프로그램, 체지방량, 나의 트레이너 부분 하나의 pane (그리드layout)
        homePane = new JPanel();
    }

    private JPanel rankingPane;
    private CardLayout rankingCards;
    RankingCardPanel rankingCardPanel = new RankingCardPanel();
    RankingBottomPanel rankingBottomPanel = new RankingBottomPanel();
    private void setupRankingPane(){
        rankingPane = new JPanel(new BorderLayout());
        rankingCards = new CardLayout();
        JPanel cardPanel = new JPanel(rankingCards);
        rankingCardPanel.setup(cardPanel);
        rankingBottomPanel.setup(rankingCards, rankingPane);

        rankingPane.add(rankingBottomPanel, BorderLayout.SOUTH);
        rankingPane.add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel programPane;
    private CardLayout programCards;
    ProgramCardPanel programCardPanel = new ProgramCardPanel();

    private void setupProgramPane(){
        programPane = new JPanel(new BorderLayout());
        programCards = new CardLayout();
        JPanel cardPanel = new JPanel(programCards);
        programCardPanel.setup(cardPanel, programCards, "!pt");

        programPane.add(cardPanel, BorderLayout.CENTER);

    }

    private JPanel trainerPane;

    private void setupTrainerPane(){
        trainerPane = new JPanel(new BorderLayout());

    }

    private JPanel myPagePane;
    private void setupMyPagePane(){
        myPagePane = new JPanel(new BorderLayout());
    }

}