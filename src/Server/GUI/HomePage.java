package Server.GUI;

import Server.ServerComputer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 홈화면은 맨 위에 home이라는 글자 있는 배너 (JLabel)
// 중간에 사진이랑 이름, 운동 몇 일 째 정보 하나의 pane
// 나의 인바디, 나의 운동기록 임티랑 글씨 하나의 pane
// 체중, 운동기록, 골격근량, 나의 프로그램, 체지방량, 나의 트레이너 부분 하나의 pane (그리드layout)
public class HomePage extends JPanel {
    public void setup(){
        Font font = new Font("맑은 고딕", Font.PLAIN, 15);
        Font middleFont = new Font("맑은 고딕", Font.BOLD, 20);
        Font bigFont = new Font("맑은 고딕", Font.BOLD, 25);
        setLayout(new BorderLayout());
        JLabel homeTopLabel = new JLabel("3대50 헬스장 홈 화면", SwingConstants.CENTER);
        homeTopLabel.setPreferredSize(new Dimension(650,50));
        homeTopLabel.setOpaque(true);
        homeTopLabel.setBackground(Color.BLACK);
        homeTopLabel.setFont(bigFont);
        homeTopLabel.setForeground(Color.white);

        //사진, 이름, 출석현황
        //로그인 한 유저 프로필 사진으로 바꾸기
        JPanel homeMiddlePane = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 30));
        JLabel imageLabel = new JLabel();
        String imagePath = ServerComputer.getAbsolutePath("data\\user-image\\" + "no image" + ".png");
        Image image = new ImageIcon(imagePath).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));

        homeMiddlePane.add(imageLabel);

        //로그인 한 유저로 이름 바꾸기
        JPanel informationPane = new JPanel(new BorderLayout());

        JPanel namePart = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 30));
        JLabel name = new JLabel("전민주");
        name.setFont(bigFont);
        JLabel nameMent = new JLabel("회원");
        nameMent.setFont(middleFont);
        namePart.add(name);
        namePart.add(nameMent);

        informationPane.add(namePart, BorderLayout.NORTH);

        //로그인 한 유저로 출석 세팅하기
        JPanel attendencePart = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 30));
        JLabel attendenceMent = new JLabel("출석");
        attendenceMent.setFont(middleFont);
        JLabel attendence = new JLabel("1일째");
        attendence.setFont(bigFont);
        attendencePart.add(attendenceMent);
        attendencePart.add(attendence);

        informationPane.add(attendencePart, BorderLayout.CENTER);

        homeMiddlePane.add(informationPane);

        //인바디(골격근량, 체지방, 체중), 운동기록, 프로그램, 트레이너
        JPanel homeBottomPane = new JPanel(new GridLayout(3,2));
    /*    JLabel one = new JLabel("1");
        JLabel two = new JLabel("2");
        JLabel three = new JLabel("3");
        JLabel four = new JLabel("4");
        JLabel five = new JLabel("5");

        homeBottomPane.add(one);
        homeBottomPane.add(two);
        homeBottomPane.add(three);
        homeBottomPane.add(four);
        homeBottomPane.add(five);
*/



        /*
        * JPanel homeMiddlePane = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 30));
        JLabel imageLabel = new JLabel();
        String imagePath = ServerComputer.getAbsolutePath("data\\user-image\\" + "no image" + ".png");
        Image image = new ImageIcon(imagePath).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));

        homeMiddlePane.add(imageLabel);
        * */
        JPanel weightPart = new JPanel(new BorderLayout());
        JLabel weightLabel = new JLabel("내 체중", SwingConstants.CENTER);
        weightLabel.setFont(middleFont);
        weightPart.add(weightLabel, BorderLayout.NORTH);

        JPanel weightImagePane = new JPanel();
        JLabel weightImageLabel = new JLabel();
        String weightImagePath = ServerComputer.getAbsolutePath("data\\home-image\\" + "체중기록" + ".png");
        Image weightImage = new ImageIcon(weightImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        weightImageLabel.setIcon(new ImageIcon(weightImage));
        weightImagePane.add(weightImageLabel);
        weightPart.add(weightImagePane, BorderLayout.CENTER);


        JLabel weight = new JLabel("76kg", SwingConstants.CENTER);
        weight.setFont(bigFont);
        weightPart.add(weight, BorderLayout.SOUTH);

        weightPart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                weightPart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                weightPart.setBackground(null);
            }
        });



        JPanel musclePart = new JPanel(new BorderLayout());
        JLabel muscleLabel = new JLabel("내 골격근량", SwingConstants.CENTER);
        muscleLabel.setFont(middleFont);
        musclePart.add(muscleLabel, BorderLayout.NORTH);

        JPanel muscleImagePane = new JPanel();
        JLabel muscleImageLabel = new JLabel();
        String muscleImagePath = ServerComputer.getAbsolutePath("data\\home-image\\" + "근력운동" + ".png");
        Image muscleImage = new ImageIcon(muscleImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        muscleImageLabel.setIcon(new ImageIcon(muscleImage));
        muscleImagePane.add(muscleImageLabel);
        musclePart.add(muscleImagePane, BorderLayout.CENTER);

        JLabel muscle = new JLabel("23kg", SwingConstants.CENTER);
        muscle.setFont(bigFont);
        musclePart.add(muscle, BorderLayout.SOUTH);

        musclePart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                musclePart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                musclePart.setBackground(null);
            }
        });


        JPanel fatPart = new JPanel(new BorderLayout());
        JLabel fatLabel = new JLabel("내 지방량", SwingConstants.CENTER);
        fatLabel.setFont(middleFont);
        fatPart.add(fatLabel, BorderLayout.NORTH);

        JPanel fatImagePane = new JPanel();
        JLabel fatImageLabel = new JLabel();
        String fatImagePath = ServerComputer.getAbsolutePath("data\\home-image\\" + "인바디기록" + ".png");
        Image fatImage = new ImageIcon(fatImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        fatImageLabel.setIcon(new ImageIcon(fatImage));
        fatImagePane.add(fatImageLabel);
        fatPart.add(fatImagePane, BorderLayout.CENTER);

        JLabel fat = new JLabel("15kg", SwingConstants.CENTER);
        fat.setFont(bigFont);
        fatPart.add(fat, BorderLayout.SOUTH);

        fatPart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fatPart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fatPart.setBackground(null);
            }
        });


        JPanel exercisePart = new JPanel(new BorderLayout());
        JLabel exerciseLabel = new JLabel("내 운동기록", SwingConstants.CENTER);
        exerciseLabel.setFont(middleFont);
        exercisePart.add(exerciseLabel, BorderLayout.NORTH);

        JPanel exerciseImagePane = new JPanel();
        JLabel exerciseImageLabel = new JLabel();
        String exerciseImagePath = ServerComputer.getAbsolutePath("data\\home-image\\" + "운동기록" + ".png");
        Image exerciseImage = new ImageIcon(exerciseImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        exerciseImageLabel.setIcon(new ImageIcon(exerciseImage));
        exerciseImagePane.add(exerciseImageLabel);
        exercisePart.add(exerciseImagePane, BorderLayout.CENTER);

        JLabel exercise = new JLabel("무산소 1시간\n유산소 1시간", SwingConstants.CENTER);
        exercise.setFont(bigFont);
        exercisePart.add(exercise, BorderLayout.SOUTH);

        exercisePart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exercisePart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exercisePart.setBackground(null);
            }
        });


        JPanel programPart = new JPanel(new BorderLayout());
        JLabel programLabel = new JLabel("내 프로그램", SwingConstants.CENTER);
        programLabel.setFont(middleFont);
        programPart.add(programLabel, BorderLayout.NORTH);

        JPanel programImagePane = new JPanel();
        JLabel programImageLabel = new JLabel();
        String programImagePath = ServerComputer.getAbsolutePath("data\\program-image\\" + "줌바댄스" + ".png");
        Image programImage = new ImageIcon(programImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        programImageLabel.setIcon(new ImageIcon(programImage));
        programImagePane.add(programImageLabel);
        programPart.add(programImagePane, BorderLayout.CENTER);

        JLabel program = new JLabel("화 12:00 줌바댄스", SwingConstants.CENTER);
        program.setFont(bigFont);
        programPart.add(program, BorderLayout.SOUTH);

        programPart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                programPart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                programPart.setBackground(null);
            }
        });



        JPanel trainerPart = new JPanel(new BorderLayout());
        JLabel trainerLabel = new JLabel("내 트레이너", SwingConstants.CENTER);
        trainerLabel.setFont(middleFont);
        trainerPart.add(trainerLabel, BorderLayout.NORTH);

        JPanel trainerImagePane = new JPanel();
        JLabel trainerImageLabel = new JLabel();
        String trainerImagePath = ServerComputer.getAbsolutePath("data\\user-image\\" + "kimJongKook" + ".png");
        Image trainerImage = new ImageIcon(trainerImagePath).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        trainerImageLabel.setIcon(new ImageIcon(trainerImage));
        trainerImagePane.add(trainerImageLabel);
        trainerPart.add(trainerImagePane, BorderLayout.CENTER);

        JLabel trainer = new JLabel("수 09:00 PT-김종국", SwingConstants.CENTER);
        trainer.setFont(bigFont);
        trainerPart.add(trainer, BorderLayout.SOUTH);

        trainerPart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                trainerPart.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                trainerPart.setBackground(null);
            }
        });



        homeBottomPane.add(weightPart);
        homeBottomPane.add(exercisePart);

        homeBottomPane.add(musclePart);
        homeBottomPane.add(programPart);

        homeBottomPane.add(fatPart);
        homeBottomPane.add(trainerPart);

        add(homeTopLabel, BorderLayout.NORTH);
        add(homeMiddlePane, BorderLayout.CENTER);
        add(homeBottomPane, BorderLayout.SOUTH);
    }

}
