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
    private CardLayout homeCards;
    HomePage homePage = new HomePage();
    HomeCardPanel homeCardPanel = new HomeCardPanel();
    private void setupHomePane(){
        homePane = new JPanel(new BorderLayout());
        homeCards = new CardLayout();
        JPanel cardPanel = new JPanel(homeCards);

        //"홈 화면" , "내 운동기록", "내 골격근량", "내 체지방", "내 체중", "내 트레이너", "내 프로그램"
        homePage.setup(cardPanel, homeCards);
        homeCardPanel.setup(cardPanel, homeCards);
        homePane.add(cardPanel, BorderLayout.CENTER);
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
        rankingBottomPanel.setup(rankingCards, cardPanel);

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
    private CardLayout trainerCards;
    ProgramCardPanel trainerCardPanel = new ProgramCardPanel();
    private void setupTrainerPane(){
        trainerPane = new JPanel(new BorderLayout());
        trainerCards = new CardLayout();
        JPanel cardPanel = new JPanel(trainerCards);
        trainerCardPanel.setup(cardPanel, trainerCards, "pt");

        trainerPane.add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel myPagePane;
    private void setupMyPagePane(){
        myPagePane = new JPanel(new BorderLayout());
    }

}