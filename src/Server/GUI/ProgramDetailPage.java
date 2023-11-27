package Server.GUI;

import Server.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ProgramDetailPage extends JPanel {
    private JTable schedule;
    private DefaultTableModel tableModel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    void setup(String panelName, ProgramCustomPage programCustomPage, CardLayout programCards, JPanel cardPanel){
        //setupTopPanel(panelName);
        setupTable(panelName, programCustomPage);
        setupMiddlePanel(panelName);
        setupBottomPanel(programCards, cardPanel);
    }

/*    void setupTopPanel(String panelName){
        topPanel = new JPanel(new BorderLayout());
        JLabel programNameLabel = new JLabel(panelName + "프로그램 시간표", SwingConstants.CENTER);
        Font programNameLabelFont = new Font("맑은 고딕", Font.PLAIN, 15);
        programNameLabel.setFont(programNameLabelFont);
        topPanel.add(programNameLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
    }*/
    void setupTable(String panelName, ProgramCustomPage programCustomPage) {

        class CustomTableCellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                //programPage에서 programList로 해당하는 부분 색깔 칠하기..
                //신청 가능 영역을 클릭하면 참여자가 뜨도록

               /* // 특정 조건에 따라 배경색 설정
                if (row == 2 && column == 2) {
                    component.setBackground(Color.RED);
                } else {
                    // 기본 배경색
                    component.setBackground(table.getBackground());
                }*/

                return component;
            }
        }

        setLayout(new BorderLayout());
        String[] header = {"시간대", "월", "화", "수", "목", "금", "토", "일"};
        tableModel = new DefaultTableModel(header, 12) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.setValueAt("09:00 ~ 10:00", 0, 0);
        tableModel.setValueAt("10:00 ~ 11:00", 1, 0);
        tableModel.setValueAt("11:00 ~ 12:00", 2, 0);
        tableModel.setValueAt("12:00 ~ 13:00", 3, 0);
        tableModel.setValueAt("13:00 ~ 14:00", 4, 0);
        tableModel.setValueAt("14:00 ~ 15:00", 5, 0);
        tableModel.setValueAt("15:00 ~ 16:00", 6, 0);
        tableModel.setValueAt("16:00 ~ 17:00", 7, 0);
        tableModel.setValueAt("17:00 ~ 18:00", 8, 0);
        tableModel.setValueAt("18:00 ~ 19:00", 9, 0);
        tableModel.setValueAt("19:00 ~ 20:00", 10, 0);
        tableModel.setValueAt("20:00 ~ 21:00", 11, 0);

        schedule = new JTable(tableModel) {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }
        };

        schedule.getTableHeader().setReorderingAllowed(false);

        // 열 크기 조정
        for (int i = 1; i <= 7; i++) {
            TableColumn column = schedule.getColumnModel().getColumn(i);
            column.setPreferredWidth(15);
        }

        for (int i = 0; i < 12; i++) {
            schedule.setRowHeight(i, 30);
        }

        schedule.setFillsViewportHeight(true);
        schedule.setCellSelectionEnabled(true);

        // 셀 렌더러 설정
        schedule.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(schedule);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.PAGE_START);
    }

    void setupMiddlePanel(String panelName){
        JLabel programNameLabel = new JLabel(panelName + " 프로그램 시간표", SwingConstants.CENTER);
        Font programNameLabelFont = new Font("맑은 고딕", Font.PLAIN, 15);
        programNameLabel.setFont(programNameLabelFont);

        middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(programNameLabel, BorderLayout.NORTH);

        JLabel participantsLabel = new JLabel("참여자 : ", SwingConstants.CENTER);
        Font participantsFont = new Font("맑은 고딕", Font.PLAIN, 30);
        participantsLabel.setFont(participantsFont);
        middlePanel.add(participantsLabel, BorderLayout.LINE_START);

        JLabel nameLabel = new JLabel("mingmingmon", SwingConstants.CENTER);
        Font nameLabelFont = new Font("맑은 고딕", Font.PLAIN, 20);
        nameLabel.setFont(nameLabelFont);
        middlePanel.add(nameLabel, BorderLayout.CENTER);
        add(middlePanel,BorderLayout.CENTER);
    }

    void setupBottomPanel(CardLayout programCards, JPanel cardPanel){
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton goBackButton = new JButton("뒤로가기");
        JButton applyButton = new JButton("신청하기");

        bottomPanel.add(goBackButton);
        bottomPanel.add(applyButton);

        goBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                programCards.show(cardPanel, "프로그램 메인화면");
            }
        });

        applyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(bottomPanel, "신청되었습니다!");
            }
        });

        add(bottomPanel, BorderLayout.SOUTH);
    }
}

/*    void setupTableFrame(){
        // page_start 부분에는 시간표, center 부분에는 참여자 목록, page_end 부분에는 뒤로가기, 신청하기 버튼
        setLayout(new BorderLayout());
        String[] header = {"시간대","월","화","수","목","금","토","일"};
        tableModel = new DefaultTableModel(header, 13) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        schedule = new JTable(tableModel) {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }
        };
        schedule.getTableHeader().setReorderingAllowed(false); // 열 이동 비활성화

        // 열 크기 조정
        for (int i = 1; i <= 7; i++) {
            TableColumn column = schedule.getColumnModel().getColumn(i);
            column.setPreferredWidth(15);
        }

        //schedule.setPreferredScrollableViewportSize(new Dimension(400, 700));
        schedule.setFillsViewportHeight(true);
        schedule.setCellSelectionEnabled(true);
        //schedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //add(schedule, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(schedule);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 비활성화
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

    }*/
