import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        //pass the db url username password in string
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/expensedb";
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database successfully");
            //design java ui for expense calculator
            JFrame frame = new JFrame();

            JLabel title = new JLabel("Expenses");
            title.setBounds(210,10,80,50);
            title.setForeground(Color.RED);
            frame.add(title);

            JLabel expensetypelabel = new JLabel("Enter Expense Type :");
            expensetypelabel.setBounds(30,50,150,50);
            expensetypelabel.setForeground(Color.BLUE);
            frame.add(expensetypelabel);

            JLabel expenseamountlabel = new JLabel("Enter Expense Amount :");
            expenseamountlabel.setBounds(30,100,150,50);
            expenseamountlabel.setForeground(Color.BLUE);
            frame.add(expenseamountlabel);

            JLabel incomelabel = new JLabel("Enter Income Amount :");
            incomelabel.setBounds(30,150,150,50);
            incomelabel.setForeground(Color.BLUE);
            frame.add(incomelabel);

            JTextField expensetypetextfield = new JTextField();
            expensetypetextfield.setBounds(180,60,120,30);
            frame.add(expensetypetextfield);

            JTextField expenseamounttextfield = new JTextField();
            expenseamounttextfield.setBounds(180,110,120,30);
            frame.add(expenseamounttextfield);

            JTextField incometextfield = new JTextField();
            incometextfield.setBounds(180,160,120,30);
            frame.add(incometextfield);

            JButton save = new JButton("Save");
            save.setBounds(200,220,80,40);
            frame.add(save);

            frame.setTitle("Saksham Expenses");
            frame.setLayout(null);
            frame.setSize(500, 400);
            frame.setVisible(true);

            //to click on save button

            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //to insert data into table
                    String insert = "insert into expense(incomeamount,expensetype,expenseamount) values(?,?,?)";
                    PreparedStatement ps = null;
                    try {
                        ps = conn.prepareStatement(insert);
                        ps.setInt(1, Integer.parseInt(incometextfield.getText()));
                        ps.setString(2,expensetypetextfield.getText());
                        ps.setInt(3, Integer.parseInt(expenseamounttextfield.getText()));
                        ps.executeUpdate();
                        conn.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}