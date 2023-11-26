package Server.GUI;

import Server.Program;

import javax.swing.*;
import java.awt.*;

public class ProgramCardPanel extends JPanel{
    void setup(JPanel cardPanel, CardLayout programCards, JPanel programPane){
        //단위가 카드
        JScrollPane programMainPanel = createProgramCustomPage("프로그램 메인화면", programCards, cardPanel);
        JPanel zombaDetailPanel = createProgramDetailPage("줌바 디테일화면", programCards, cardPanel);
        JPanel yogaDetailPanel = createProgramDetailPage("요가 디테일화면" , programCards, cardPanel);


        cardPanel.add(programMainPanel, "프로그램 메인화면");
        cardPanel.add(zombaDetailPanel, "줌바 디테일화면");
        cardPanel.add(yogaDetailPanel, "요가 디테일화면");
    }

    private JScrollPane createProgramCustomPage(String panelName, CardLayout programCards, JPanel cardPanel) {
        //JPanel panel = new JPanel();
        Box containerBox = Box.createVerticalBox();
        //containerBox.setLayout(new BoxLayout(containerBox, BoxLayout.Y_AXIS));
        ProgramCustomPage zombaPage = new ProgramCustomPage("줌바 이미지", "줌바", "줌바댄스입니다", "줌바 디테일화면",  programCards, cardPanel);
        containerBox.add(zombaPage);

        ProgramCustomPage yogaPage = new ProgramCustomPage("요가 이미지", "요가", "요가입니다", "요가 디테일화면",  programCards, cardPanel);
        containerBox.add(yogaPage);

        ProgramCustomPage airPage = new ProgramCustomPage("에어로빅 이미지", "에어로빅", "에어로빅입니다", "에어로빅 디테일화면",  programCards, cardPanel);
        containerBox.add(airPage);

        ProgramCustomPage cyclePage = new ProgramCustomPage("사이클 이미지", "사이클", "사이클입니다", "사이클 디테일화면",  programCards, cardPanel);
        containerBox.add(cyclePage);

        ProgramCustomPage cyclePage2 = new ProgramCustomPage("사이클 이미지", "사이클", "사이클입니다", "사이클 디테일화면",  programCards, cardPanel);
        containerBox.add(cyclePage2);


        JScrollPane scrollPane = new JScrollPane(containerBox);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤 비활성화
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //int visiblePages = 4;

        //이게 스크롤 속도 조절하는 것 같음.
        scrollPane.getVerticalScrollBar().setUnitIncrement(containerBox.getComponent(0).getPreferredSize().height / 8);
        //scrollPane.getVerticalScrollBar().setBlockIncrement(visiblePages * containerBox.getComponent(0).getPreferredSize().height);
        return scrollPane;
    }

    private JPanel createProgramDetailPage(String panelName, CardLayout programCards, JPanel programPane) {
        JPanel panel = new JPanel(new GridLayout(5,1));
        ProgramDetailPage detailPage = new ProgramDetailPage();
        detailPage.setup(panelName, programCards, programPane);
        panel.add(detailPage);
        return panel;
    }
}
