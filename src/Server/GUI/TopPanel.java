package Server.GUI;

import Server.GUI.TableSection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanel extends JPanel {
    // Item 검색 탭의 상단 패널 구성하기
    JTextField kwdTextField = new JTextField("", 20);
    void setupTopPane(TableSection tableSection) {
        JPanel topPane = new JPanel();
        JButton detail = new JButton("상세보기");
        topPane.add(detail, BorderLayout.LINE_START);
        topPane.add(kwdTextField, BorderLayout.CENTER);
        JButton search = new JButton("검색");
        topPane.add(search, BorderLayout.LINE_END);
        add(topPane, BorderLayout.PAGE_START);

        detail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("상세보기")) {
                    tableSection.showDetail();
                }
            }
        });
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("검색")) {
                    tableSection.loadData(kwdTextField.getText());
                }
            }
        });
    }
}
