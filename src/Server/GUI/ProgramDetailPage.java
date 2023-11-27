package Server.GUI;

import Server.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ProgramDetailPage extends JPanel {
    private JLabel titleLabel;

    private JTable schedule;
    private DefaultTableModel tableModel;

    void setup(String panelName, ProgramCustomPage programCustomPage, CardLayout programCards, JPanel cardPanel){
        setLayout(new BorderLayout());

        titleLabel = new JLabel(panelName);
        add(titleLabel, BorderLayout.SOUTH);

        String[] header = {"시간대","월","화","수","목","금","토","일"};
        tableModel = new DefaultTableModel(header, 13) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        schedule = new JTable(tableModel);
        schedule.setPreferredScrollableViewportSize(new Dimension(400, 700));
        schedule.setFillsViewportHeight(true);
        schedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(schedule);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 비활성화
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       // scrollPane.setSize(400,700);
        //int visiblePages = 4;

        add(scrollPane, BorderLayout.NORTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭되었을 때 다른 화면으로 이동
                //showPanel(detailPageName, programCards, programPane);
                programCards.show(cardPanel, "프로그램 메인화면");
            }
        });
    }
}
