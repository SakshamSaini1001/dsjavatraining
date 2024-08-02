package javaprojects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addgame {
    static JLabel numlabel,numlabel2,operator,question,scorelabel,timerlabel;
    static JTextField answer;
    static JButton submit;
    static int num1;static int num2; static int timeleft = 45,score=0;static int sum = 0;
    static Timer timer;
    public static void main(String[] args) {
        addgame.addition();
    }
    static void addition() {
        JFrame frame = new JFrame();
        numlabel = new JLabel();
        numlabel2 = new JLabel();
        operator = new JLabel("+");
        question = new JLabel("Add the numbers");
        scorelabel = new JLabel();
        answer = new JTextField();
        submit = new JButton("SUBMIT");
        timerlabel = new JLabel("45");

        numlabel.setBounds(70,70,80,20);
        operator.setBounds(130,70,50,20);
        numlabel2.setBounds(180,70,80,20);
        question.setBounds(85,30,110,40);
        answer.setBounds(75,100,120,20);
        submit.setBounds(85,125,100,35);
        timerlabel.setBounds(200,20,60,35);
        scorelabel.setBounds(95,150,100,35);

        frame.add(numlabel);
        frame.add(operator);
        frame.add(numlabel2);
        frame.add(question);
        frame.add(answer);
        frame.add(submit);
        frame.add(timerlabel);
        frame.add(scorelabel);
        frame.setTitle("add game");
        frame.setLayout(null);
        frame.setSize(300, 250);
        check();
        timermethod();
        frame.setVisible(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(answer.getText());
                if(n == sum){
                    score++;
                    scorelabel.setText("Score: "+score);
                    check();
                    timermethod();
                }
                else {
                   JOptionPane.showMessageDialog(null,"Game Over Score:"+score);
                }
            }
        });
    }
    static void check(){
        Random random = new Random();
        num1 = random.nextInt(1000);
        num2 = random.nextInt(1000);
        sum = num1 + num2;
        numlabel.setText(String.valueOf(num1));
        numlabel2.setText(String.valueOf(num2));
    }
    /*void starttimer(){
        int timeleft = 45;
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int timeleft--;
                timerlabel.setText("Time :"+timeleft);
                if(timeleft <= 0){
                    timer.stop();
                }
            }
        });
    }*/
    static void timermethod(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeleft = 45;
                timeleft--;
                timerlabel.setText("Time: " + timeleft);
                if (timeleft <= 0) {
                    timer.stop();
                    //JOptionPane.showMessageDialog(null, "Time's up! Final Score: " + score);
                }
            }
        });
        timer.start();
    }

}
