package Server.GUI;

import Server.ServerComputer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

public class LogIn extends JPanel {
    private JPanel logInPane;
    private JTextField idField;
    private JPasswordField passwordField;

    void setupLogInPage(JPanel cardPanel, CardLayout startCards) {
        logInPane = new JPanel(new BorderLayout());

        TopBanner topBanner = new TopBanner();
        logInPane.add(topBanner, BorderLayout.NORTH);

        JPanel informationEnterPanel = new JPanel();
        //informationEnterPanel.setLayout(new BoxLayout(informationEnterPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel idLabel = new JLabel("아이디 : ");
        idField = new JTextField();
        idField.setColumns(20);
        idPanel.add(idLabel);
        idPanel.add(idField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel passwordLabel = new JLabel("비밀번호 : ");
        passwordField = new JPasswordField();
        passwordField.setColumns(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        String myInfoPath = "..\\Client\\my-info.txt";
        if (new File(ServerComputer.getAbsolutePath(myInfoPath)).exists()) {
            Scanner file = ServerComputer.openFile(myInfoPath);
            idField.setText(file.next());
            passwordField.setText(file.next());

        }


        informationEnterPanel.add(idPanel);
        informationEnterPanel.add(passwordPanel);

        logInPane.add(informationEnterPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton logInButton = new JButton("로그인");
        JButton joinButton = new JButton("회원가입");
        bottomPanel.add(logInButton);
        bottomPanel.add(joinButton);

        logInPane.add(bottomPanel, BorderLayout.SOUTH);

        cardPanel.add(logInPane, "로그인 페이지");
        logInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tryLogIn(cardPanel, startCards);
            }
        });
    }
    void tryLogIn(JPanel cardPanel, CardLayout startCards) {
        int logInType = ServerComputer.getAccessType(new String[]{idField.getText(), passwordField.getText()});
        if (logInType == -1) {
            System.out.println("입력이 올바르지 않습니다.");
            return;
        } else if (logInType == 1) {
            System.out.println("존재하지 않는 게정입니다.");
            return;
        } else if (logInType == 2) {
            System.out.println("비밀번호가 맞지 않습니다.");
            return;
        }
            startCards.show(cardPanel, "로그인후 페이지");
    }

}