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

    static JFrame mainFrame = new JFrame("3대50 헬스장");
    private JPanel startPane;
    private CardLayout startCards;
    LogIn loginCard = new LogIn();
    LogIned loginedCard = new LogIned();
    Join joinCard = new Join();
    private void setupStartPane(){
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startPane = new JPanel(new BorderLayout());
        startCards = new CardLayout();
        JPanel cardPanel = new JPanel(startCards);

        loginCard.setupLogInPage(cardPanel, startCards);
        loginedCard.createAndShowGUI(cardPanel);
        joinCard.setupJoinPage(cardPanel, startCards);
        startPane.add(cardPanel, BorderLayout.CENTER);

        mainFrame.getContentPane().add(startPane);
        mainFrame.pack();
        mainFrame.setSize(500, 700);
        mainFrame.setVisible(true);
    }
}

