import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class currencyconvertorswing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("currency convertor");
        JLabel dollarlabel = new JLabel("Enter Amount in USD:");
        JLabel inrlabel = new JLabel("Enter Amount in INR:");
        JLabel convertor = new JLabel();
        JTextField dollarfield = new JTextField();
        JTextField inrfield = new JTextField();
        JButton convert = new JButton("Convert");

        dollarlabel.setBounds(30,30,150,40);
        dollarfield.setBounds(160,30,150,40);
        inrlabel.setBounds(30,70,150,40);
        inrfield.setBounds(160,70,150,40);
        convert.setBounds(30,130,150,40);
        convertor.setBounds(180,130,150,40);

        frame.add(dollarlabel);
        frame.add(dollarfield);
        frame.add(inrlabel);
        frame.add(inrfield);
        frame.add(convert);
        frame.add(convertor);
        frame.setLayout(null);
        frame.setSize(400,250);
        frame.setVisible(true);

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(inrfield.getText().isEmpty() && !dollarfield.getText().isEmpty()) {
                    float dollarvalue = Float.parseFloat(dollarfield.getText());
                    float output = (float) (dollarvalue * 83.73);
                    convertor.setText("USD to INR :" + output);
                }
                else if (!inrfield.getText().isEmpty() && dollarfield.getText().isEmpty()) {
                    float inrvalue = Float.parseFloat(inrfield.getText());
                    float outputusd = (float) (inrvalue/83.73);
                    convertor.setText("INR to USD :" + outputusd);
                }
                else if(!inrfield.getText().isEmpty() && !(dollarfield.getText().isEmpty())){
                    float inrvalue = Float.parseFloat(inrfield.getText());
                    float dollarvalue = Float.parseFloat(dollarfield.getText());
                    float output = (float) (dollarvalue * 83.73);
                    float outputusd = (float) (inrvalue/83.73);
                    convertor.setText("in INR" + output + "in usd"+ outputusd);
                }
                else {
                    convertor.setText("enter a value");
                }
                }
        });
    }
}
