package Server.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
    private static GUIMain guiMain = null;
    private GUIMain(){}
    public static GUIMain getInstance(){
        if (guiMain == null)
            guiMain = new GUIMain();
        return guiMain;
    }

    public static void startGUI(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIMain.getInstance().createAndShowGUI();
            }
        });
    }

    static JFrame mainFrame = new JFrame("3대50 헬스장");
    private void createAndShowGUI() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        mainFrame.getContentPane().add(topTab);
        mainFrame.pack();
        mainFrame.setSize(400, 700);
        mainFrame.setVisible(true);
    }

    private JPanel homePane;
    private void setupHomePane(){
        // 홈화면은 맨 위에 home이라는 글자 있는 배너 (JLabel)
        // 중간에 사진이랑 이름, 운동 몇 일 째 정보 하나의 pane
        // 나의 인바디, 나의 운동기록 임티랑 글씨 하나의 pane
        // 체중, 운동기록, 골격근량, 나의 프로그램, 체지방량, 나의 트레이너 부분 하나의 pane (그리드layout)
        homePane = new JPanel();
    }

    private static JPanel rankingPane = null;

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
    //TableSection programTable = new TableSection();
    //TopPanel programTopPanel = new TopPanel();
    private void setupProgramPane(){
        //BorderLayout은 화면을 동서남북, 중앙으로 나누고 각 영역에 BorderLayout.NORTH로 컴포넌트를 배치할 수 있음
        programPane = new JPanel(new BorderLayout());
        programCards = new CardLayout();
        //cardPanel이 cardlayout의 부모 컨테이너
        JPanel cardPanel = new JPanel(programCards);
        programCardPanel.setup(cardPanel, programCards, programPane);

        programPane.add(cardPanel, BorderLayout.CENTER);
        /*programTable.tableTitle = "Program";
        programTable.addComponentsToPane(ProgramGUIManager.getInstance(), "!pt");
        programPane.add(programTable, BorderLayout.CENTER);
        programTopPanel.setupTopPane(programTable);
        programPane.add(programTopPanel, BorderLayout.NORTH);*/
    }

    private JPanel trainerPane;
    /*TableSection trainerTable = new TableSection();
    TopPanel trainerTopPanel = new TopPanel();*/
    private void setupTrainerPane(){
        trainerPane = new JPanel(new BorderLayout());

       /* trainerTable.tableTitle = "PT";
        trainerTable.addComponentsToPane(ProgramGUIManager.getInstance(), "pt");
        trainerPane.add(trainerTable, BorderLayout.CENTER);
        trainerTopPanel.setupTopPane(trainerTable);
        trainerPane.add(trainerTopPanel, BorderLayout.NORTH);*/
    }

    private JPanel myPagePane;
    private void setupMyPagePane(){
        myPagePane = new JPanel(new BorderLayout());
    }
}

