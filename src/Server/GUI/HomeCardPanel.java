package Server.GUI;

import javax.swing.*;
import java.awt.*;

public class HomeCardPanel extends JPanel {
    void setup(JPanel cardPanel, CardLayout homeCards){
        JPanel myWeight = createCard("내 체중", cardPanel, homeCards);
        JPanel myMuscle = createCard("내 골격근량", cardPanel, homeCards);
        JPanel myFat = createCard("내 지방량", cardPanel, homeCards);
        JPanel myExerciseLog = createCard("내 운동기록", cardPanel, homeCards);
        JPanel myProgram = createCard("내 프로그램", cardPanel, homeCards);
        JPanel myTrainer = createCard("내 트레이너", cardPanel, homeCards);

        cardPanel.add(myWeight, "내 체중");
        cardPanel.add(myMuscle, "내 골격근량");
        cardPanel.add(myFat, "내 지방량");
        cardPanel.add(myExerciseLog, "내 운동기록");
        cardPanel.add(myProgram, "내 프로그램");
        cardPanel.add(myTrainer, "내 트레이너");
    }

    private JPanel createCard(String cardName, JPanel cardPanel, CardLayout homeCards){
        HomeCardPage homeCardPage = new HomeCardPage();
        homeCardPage.setup(cardName, cardPanel, homeCards);
        return homeCardPage;
    }

}
