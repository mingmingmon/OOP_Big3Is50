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
    private CardLayout honeCards;
    private HomePage homePage;
    private void setupHomePane(){
        homePane = new JPanel();
        homePage = new HomePage();
        homePage.setup();
        homePane.add(homePage);
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