package Server.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Flow;

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
                GUIMain.getInstance().setupStartPane();
            }
        });
    }

    private JPanel startPane;
    private CardLayout startCards;
    LogIn loginCard = new LogIn();
    LogIned loginedCard = new LogIned();
    private void setupStartPane(){
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startPane = new JPanel(new BorderLayout());
        startCards = new CardLayout();
        JPanel cardPanel = new JPanel(startCards);


        loginCard.setupLogInPage(cardPanel, startCards);
        //cardPanel.add(loginCard, "로그인 페이지");

        loginedCard.createAndShowGUI(cardPanel, startCards);
        //cardPanel.add(loginedCard, "로그인후 페이지");

        startPane.add(cardPanel, BorderLayout.CENTER);

        //startCards.show(cardPanel, "로그인 페이지");

        //mainFrame.getContentPane().add(logInPane);
        mainFrame.getContentPane().add(startPane);
        mainFrame.pack();
        mainFrame.setSize(500, 700);
        mainFrame.setVisible(true);
    }


    static JFrame mainFrame = new JFrame("3대50 헬스장");
/*
* import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("로그인 화면");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("사용자명:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("로그인");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // 공백 레이블
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // 로그인 시도
                if (attemptLogin(username, password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "로그인 성공!");
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "로그인 실패. 다시 시도하세요.");
                }
            }
        });

        add(panel);
        setLocationRelativeTo(null); // 화면 중앙에 표시
        setVisible(true);
    }

    private boolean attemptLogin(String username, String password) {
        // 실제 로그인 처리를 여기에 구현
        // 이 예제에서는 간단히 사용자명이 "user"이고 비밀번호가 "password"인 경우에만 로그인 성공으로 처리
        return username.equals("user") && password.equals("password");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
*/

    class LogIned extends JPanel{
        void createAndShowGUI(JPanel cardPanel, CardLayout startCards) {

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
        /*mainFrame.getContentPane().add(topTab);
        mainFrame.pack();
        mainFrame.setSize(500, 800);
        //mainFrame.setResizable(false);
        mainFrame.setVisible(true);*/
        }
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
    //TableSection programTable = new TableSection();
    //TopPanel programTopPanel = new TopPanel();
    private void setupProgramPane(){
        //BorderLayout은 화면을 동서남북, 중앙으로 나누고 각 영역에 BorderLayout.NORTH로 컴포넌트를 배치할 수 있음
        programPane = new JPanel(new BorderLayout());
        programCards = new CardLayout();
        JPanel cardPanel = new JPanel(programCards);
        programCardPanel.setup(cardPanel, programCards, "!pt");

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

