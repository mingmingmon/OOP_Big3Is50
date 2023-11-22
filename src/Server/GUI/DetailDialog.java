package Server.GUI;

import Server.GUI.GUIMain;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

public class DetailDialog extends javax.swing.JDialog {
    String[] itemDetails;
    JLabel details[];
    int n;
    DetailDialog(String[] texts) {
        super(GUIMain.mainFrame);
        itemDetails = texts;

        n = itemDetails.length;
        details = new JLabel[n];
    }
    void setup() {
        setTitle("상품상세보기");
        JPanel pane = new JPanel(new BorderLayout());
        JPanel lpane = new JPanel(new GridLayout(n, 1));
        JLabel photo = new JLabel("   Photo   ");
        photo.setOpaque(true);  // JLabel은 기본이 배경 투명
        photo.setPreferredSize(new Dimension(150, 150));
        photo.setBackground(Color.YELLOW);
        for (int i = 0; i < n; i++) {
            details[i] = new JLabel(itemDetails[i]);
            lpane.add(details[i]);
        }
        pane.add(lpane, BorderLayout.CENTER);
        pane.add(photo, BorderLayout.LINE_END);
        this.setMinimumSize(new Dimension(400, 150));  // 대화상자 크기 설정
        setContentPane(pane);
    }
}
