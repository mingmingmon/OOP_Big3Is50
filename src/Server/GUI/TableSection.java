package Server.GUI;

import Server.Facade.IDataEngine;
import Server.Facade.UIData;
import Server.Program;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TableSection extends JPanel implements ListSelectionListener {
    JTable table;
    DefaultTableModel tableModel;
    int selectedIndex = -1;   // 테이블에서 선택된 행의 인덱스를 가질 변수
    String tableTitle = null;
    IDataEngine<?> dataMgr;  // 엔진 쪽의 데이터를 관리하는 매니저 파사드 인터페이스
    ArrayList<?> dataList;
    String defaultFilter;

    public TableSection() {
        super(new BorderLayout());
    }
    // 테이블을 생성하여 초기화하고 스크롤 붙여서 패널에 add한다
    void addComponentsToPane(IDataEngine<?> mgr) {
        addComponentsToPane(mgr, "");
    }
    void addComponentsToPane(IDataEngine<?> mgr, String keyword) {
        defaultFilter = keyword;
        init(mgr, defaultFilter);
        JScrollPane center = new JScrollPane(table);
        add(center, BorderLayout.CENTER);
    }
    // 테이블의 기본 설정을 하는 부분 (테이블 모델을 생성하고 초기 데이터 불러오고
    // 테이블에 필요한 설정을 초기화한다
    // 장바구니 테이블은 오버라이드하여 가져올 주문번호를 세팅한 후 수퍼 호출
    @SuppressWarnings("serial")
    void init(IDataEngine<?> mgr, String keyword) {
        dataMgr = mgr;
        tableModel = new DefaultTableModel(mgr.getColumnNames(), 0){
            // 셀 수정 못하게 하는 부분
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        loadData(keyword);

        table = new JTable(tableModel);
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(this);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    // 매니저에서 검색된 객체들을 테이블에 보여준다. kwd가 ""면 모두 출력
    void loadData(String kwd) {
        if(kwd.contentEquals("") && !defaultFilter.contentEquals(""))
            kwd = defaultFilter;

        dataList = dataMgr.search(kwd); // 매니저에서 검색결과를 가져옴
        tableModel.setRowCount(0);  // 현재 데이터모델의 행을 모두 지운다
        for (Object m : dataList) {     // 한 행씩 추가함
            tableModel.addRow(((UIData) m).getSimpleData());
        }
    }
    // 아이템 패널에서 상세보기 버튼을 눌렀을 때 실행되는 메소드
    void showDetail() {
        if (selectedIndex < 0)
            return;

        String[] uiData = ((UIData)dataList.get(selectedIndex)).getDetailData();
        DetailDialog dlg = new DetailDialog(uiData);
        dlg.setup();
        dlg.pack();
        dlg.setVisible(true);
    }
    // 선택된 행이 변경되면 그 내용을 편집창으로 보냄
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
            selectedIndex = lsm.getMinSelectionIndex();
            String name = (String)tableModel.getValueAt(selectedIndex, 0);


            /*if (tableTitle.equals("Program")) {
                GUIMain.getInstance().programTopPanel.kwdTextField.setText(name);
            } else if (tableTitle.equals("PT")) {
                GUIMain.getInstance().trainerTopPanel.kwdTextField.setText(name);
            }*/
        }
    }
}
