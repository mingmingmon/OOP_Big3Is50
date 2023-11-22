package Server.GUI;

import javax.swing.*;
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

    private JPanel rankingPane;
    private void setupRankingPane(){
        rankingPane = new JPanel(new BorderLayout());
    }

    private JPanel programPane;
    TableSection programTable = new TableSection();
    TopPanel programTopPanel = new TopPanel();
    private void setupProgramPane(){
        //BorderLayout은 화면을 동서남북, 중아으로 나누고 각 영역에 BorderLayout.NORTH로 컴포넌트를 배치할 수 있음
        programPane = new JPanel(new BorderLayout());

        programTable.tableTitle = "Program";

        programTable.addComponentsToPane(ProgramGUIManager.getInstance(), "!pt");
        programPane.add(programTable, BorderLayout.CENTER);

        programTopPanel.setupTopPane(programTable);
        programPane.add(programTopPanel, BorderLayout.NORTH);
    }

    private JPanel trainerPane;
    TableSection trainerTable = new TableSection();
    TopPanel trainerTopPanel = new TopPanel();
    private void setupTrainerPane(){
        trainerPane = new JPanel(new BorderLayout());

        trainerTable.tableTitle = "PT";

        trainerTable.addComponentsToPane(ProgramGUIManager.getInstance(), "pt");
        trainerPane.add(trainerTable, BorderLayout.CENTER);

        trainerTopPanel.setupTopPane(trainerTable);
        trainerPane.add(trainerTopPanel, BorderLayout.NORTH);
    }

    private JPanel myPagePane;
    private void setupMyPagePane(){
        myPagePane = new JPanel(new BorderLayout());
    }
}

/* cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 홈 화면
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("홈화면"));

        JButton rankingButton = new JButton("랭킹보기");
        JButton myPageButton = new JButton("마이페이지");
        JButton programListButton = new JButton("프로그램 리스트");
        JButton trainerListButton = new JButton("트레이너 리스트");

        rankingButton.setBounds(30,170,122,30);
        myPageButton.setBounds(182,170,122,30);


        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "랭킹보기");
            }
        });
        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "마이페이지");
            }
        });
        programListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "프로그램 리스트");
            }
        });
        trainerListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "트레이너 리스트");
            }
        });

        homePanel.add(rankingButton);
        homePanel.add(myPageButton);
        homePanel.add(programListButton);
        homePanel.add(trainerListButton);

        // 랭킹 화면
        JPanel rankingPanel = new JPanel();
        rankingPanel.add(new JLabel("랭킹보기"));
        JButton switchBackButton = new JButton("홈화면으로 돌아가기");
        switchBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "홈화면");
            }
        });
        rankingPanel.add(switchBackButton);

        // 마이페이지 화면
        JPanel myPagePanel = new JPanel();
        myPagePanel.add(new JLabel("마이페이지보기"));
        switchBackButton = new JButton("홈화면으로 돌아가기");
        switchBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "홈화면");
            }
        });
        myPagePanel.add(switchBackButton);

        // 프로그램 화면
        JPanel programListPanel = new JPanel();
        programListPanel.add(new JLabel("프로그램 리스트"));
        switchBackButton = new JButton("홈화면으로 돌아가기");
        switchBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "홈화면");
            }
        });
        programListPanel.add(switchBackButton);

        // 프로그램 화면
        JPanel trainerListPanel = new JPanel();
        trainerListPanel.add(new JLabel("트레이너 리스트"));
        switchBackButton = new JButton("홈화면으로 돌아가기");
        switchBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "홈화면");
            }
        });
        trainerListPanel.add(switchBackButton);

        cardPanel.add(homePanel, "홈화면");
        cardPanel.add(rankingPanel, "랭킹보기");
        cardPanel.add(myPagePanel, "마이페이지");
        cardPanel.add(programListPanel, "프로그램 리스트");
        cardPanel.add(trainerListPanel, "트레이너 리스트");

        frame.add(cardPanel);

        frame.setSize(400, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/