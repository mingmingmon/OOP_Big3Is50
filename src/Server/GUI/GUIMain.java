package Server.GUI;

import GUI_store.store.ItemMgr;
import GUI_store.store.OrderMgr;
import GUI_store.store.OrderedItemMgr;

import javax.swing.*;
import java.awt.*;

public class GUIMain {
	// 싱글톤 패턴 적용 부분
	private static GUIMain main = null;
	private GUIMain() {}
	public static GUIMain getInstance() {
		if (main == null)
			main = new GUIMain();
		return main;
	}
	// 엔진의 인스턴스를 편리를 위해 변수에 저장한다
    public static void startGUI() {
        // 이벤트 처리 스레드를 만들고 
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIMain.getInstance().createAndShowGUI();
            }
        });
    }
    /**
     * GUI를 생성하여 보여준다. 스레드 안전을 위하여
     * 이 메소드는 이벤트 처리 스레드에서 불려져야 한다.
     */
	static JFrame mainFrame = new JFrame("TableSelectionDemo");
    private void createAndShowGUI() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 탭을 생성하고 두개 패널을 추가한다.
        JTabbedPane jtab = new JTabbedPane();
        
        setupItemPane();
        setupOrderPane();
        // 아이템 리스트 탭과 주문 탭 두 개의 패널을 가지는 탭 패널
        jtab.add("아이템", itemPane);
        jtab.add("주문", orderPane);
        mainFrame.getContentPane().add(jtab);
        //Display the window.
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    // 상품을 보여주는 패널 부분 - 탑과 JTable 포함
    private JPanel itemPane;
    TableSelectionDemo itemTable = new TableSelectionDemo();
    ItemTopPanel itemTop = new ItemTopPanel();  // 검색과 상세보기 버튼을 가진 패널
    private void setupItemPane() {
    	itemPane = new JPanel(new BorderLayout());
        // Create and set up the content pane.
        itemTable.tableTitle = "item";
        itemTable.addComponentsToPane(ItemMgr.getInstance());  // 싱글톤
        itemTop.setupTopPane(itemTable);
        itemPane.add(itemTop, BorderLayout.NORTH);
        itemPane.add(itemTable, BorderLayout.CENTER);
    }
    // 상품을 보여주는 패널 부분 - 위에는 주문 JTable, 아래 패널은 장바구니와 버튼
    private JPanel orderPane;
    TableSelectionDemo orderTable = new TableSelectionDemo();
    BasketTableDemo basketTable = new BasketTableDemo();
    private void setupOrderPane() {
    	orderPane = new JPanel(new BorderLayout());
        orderTable.tableTitle = "order";
        orderTable.addComponentsToPane(OrderMgr.getInstance());
        orderPane.add(orderTable, BorderLayout.CENTER);
        // 아래쪽은 장바구니 테이블과 라벨로 나누기 위해 패널 추가
        JPanel bottom = new JPanel();  // 디폴트 플로우레이아웃
        basketTable.tableTitle = "basket";
        basketTable.addComponentsToPane(OrderedItemMgr.getInstance());

        bottom.add(basketTable, BorderLayout.CENTER);
        // 여기에 여러 가지 버튼을 넣을 수 있음 - 결재, 취소, 추가, 변경 등
        bottom.add(new JLabel("장바구니 테스트"), BorderLayout.LINE_END);
        orderPane.add(bottom, BorderLayout.SOUTH);
    }
}