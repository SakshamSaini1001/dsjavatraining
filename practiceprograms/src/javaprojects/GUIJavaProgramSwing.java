import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJavaProgramSwing {
    public static void main(String[] args) {
        //to create a frame using swing
        JFrame frame = new JFrame("BMI Calculator");

        //create UI component for bmi calculation
        JLabel heightLabel = new JLabel("Enter your Height (m) :");
        JLabel weightLabel = new JLabel("Enter your Weight (kg) :");
        JLabel bmiLabel = new JLabel();

        JTextField weightfield = new JTextField();
        JTextField heightfield = new JTextField();

        JButton bmiButton = new JButton("Calculate BMI");
        //to set size and position of UI component
        heightLabel.setBounds(30,30,150,40);
        heightfield.setBounds(170,30,50,40);
        weightLabel.setBounds(30,80,150,40);
        weightfield.setBounds(170,80,50,40);
        bmiButton.setBounds(30,130,120,40);
        bmiLabel.setBounds(170,130,100,40);

        //to attach label to frame
        frame.add(heightLabel);
        frame.add(heightfield);
        frame.add(weightLabel);
        frame.add(weightfield);
        frame.add(bmiButton);
        frame.add(bmiLabel);

        //to build default layout
        frame.setLayout(null);
        //to set the size of frame
        frame.setSize(300,250);
        //to visible frame on screen
        frame.setVisible(true);

        //to click on bmi button
        bmiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //to apply bmi formula
                float weight = Float.parseFloat(weightfield.getText().toString());
                float height = Float.parseFloat(heightfield.getText().toString());
                float output = weight / (height * height);
                //18.5 < underweight,18.5 to 24.9 = normal,24.9 to 29.9 overweight, 29 > obesity
                if (output < 18.5) {
                    bmiLabel.setText("I am Underweight");
                } else if (output > 18.5 && output < 24.9) {
                    bmiLabel.setText("I am Normal");
                } else if (output > 24.9 && output < 29.9) {
                    bmiLabel.setText("I am Overweight");
                } else {
                    bmiLabel.setText("I am Obese");
                }
            }
        });

    }
}
