import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //pass the db url username password in string
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/expensedb";
    static Connection conn ;
    static JTextField expensetypetextfield;
    static JTextField expenseamounttextfield;
    static JTextField incometextfield;
    static JTextField deletefield;
    public static void main(String[] args){
        createframe();
    }
    private static void createframe() {
        try {
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database successfully");
            //design java ui for expense calculator
            JFrame frame = new JFrame();

            JLabel title = new JLabel("Expenses");
            title.setBounds(210,10,180,50);
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

            expensetypetextfield = new JTextField();
            expensetypetextfield.setBounds(180,60,120,30);
            frame.add(expensetypetextfield);

            expenseamounttextfield = new JTextField();
            expenseamounttextfield.setBounds(180,110,120,30);
            frame.add(expenseamounttextfield);

            incometextfield = new JTextField();
            incometextfield.setBounds(180,160,120,30);
            frame.add(incometextfield);

            JButton save = new JButton("Save");
            save.setBounds(250,220,80,40);
            frame.add(save);

            JButton clearbutton = new JButton("clear");
            clearbutton.setBounds(50,220,80,40);
            frame.add(clearbutton);

            JButton deletebutton = new JButton("delete");
            deletebutton.setBounds(150,220,80,40);
            frame.add(deletebutton);

            JButton viewbutton = new JButton("View");
            viewbutton.setBounds(350,220,80,40);
            frame.add(viewbutton);

            viewbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (save.isVisible()) {
                        //to hide the insertion form
                        incomelabel.setVisible(false);
                        incometextfield.setVisible(false);
                        expensetypetextfield.setVisible(false);
                        expensetypelabel.setVisible(false);
                        expenseamountlabel.setVisible(false);
                        expenseamounttextfield.setVisible(false);
                        save.setVisible(false);
                        title.setText("Enter ID to Update Expense");

                        deletefield = new JTextField();
                        deletefield.setBounds(70, 100, 180, 40);
                        frame.add(deletefield);
                    }
                    else {
                        String deletequery = "Select * from expense where id = ?";
                        try {
                            PreparedStatement ps = conn.prepareStatement(deletequery);
                            ps.setInt(1, Integer.parseInt(deletefield.getText()));
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()){
                                int a = rs.getInt("id");
                                System.out.println("id "+ a);
                                System.out.println("income amount "+ rs.getString("incomeamount"));
                                System.out.println("expense amount "+ rs.getString("expenseamount"));
                                System.out.println("expense type "+ rs.getString("expensetype"));
                                incometextfield.setText(String.valueOf(rs.getInt("incomeamount")));
                                expenseamounttextfield.setText(String.valueOf(rs.getInt("expenseamount")));
                                expensetypetextfield.setText(rs.getString("expensetype"));
                                JButton updateButton = new JButton("Update");
                                updateButton.setBounds(200,280,80,40);
                                frame.add(updateButton);
                                updateButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String updateQuery = "update expense set incomeamount = ?, expensetype = ?, expenseamount = ? where id = ?";
                                        try {
                                            PreparedStatement ps = conn.prepareStatement(updateQuery);
                                            ps.setInt(1, Integer.parseInt(incometextfield.getText()));
                                            ps.setString(2, expensetypetextfield.getText());
                                            ps.setInt(3, Integer.parseInt(expenseamounttextfield.getText()));
                                            ps.setInt(4,a );
                                            ps.executeUpdate();
                                        } catch (SQLException ex) {
                                            throw new RuntimeException(ex);
                                        }

                                    }
                                });
                            }
                            JOptionPane.showMessageDialog(null, "Expense Fetched Successfully");
                            expensetypelabel.setVisible(true);
                            expensetypetextfield.setVisible(true);
                            expenseamountlabel.setVisible(true);
                            expenseamounttextfield.setVisible(true);
                            incomelabel.setVisible(true);
                            incometextfield.setVisible(true);
                            deletefield.setVisible(false);
                            save.setVisible(true);
                            title.setText("Expense Calculator");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });

            deletebutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (save.isVisible()) {
                        //to hide the insertion form
                        incomelabel.setVisible(false);
                        incometextfield.setVisible(false);
                        expensetypetextfield.setVisible(false);
                        expensetypelabel.setVisible(false);
                        expenseamountlabel.setVisible(false);
                        expenseamounttextfield.setVisible(false);
                        save.setVisible(false);
                        title.setText("Enter ID to Delete Expense");

                        deletefield = new JTextField();
                        deletefield.setBounds(70, 100, 180, 40);
                        frame.add(deletefield);
                    }
                    else {
                        String deletequery = "delete from expense where id = ?";
                        try {
                            PreparedStatement ps = conn.prepareStatement(deletequery);
                            ps.setInt(1, Integer.parseInt(deletefield.getText()));
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Expense Deleted Successfully");
                            expensetypelabel.setVisible(true);
                            expensetypetextfield.setVisible(true);
                            expenseamountlabel.setVisible(true);
                            expenseamounttextfield.setVisible(true);
                            incomelabel.setVisible(true);
                            incometextfield.setVisible(true);
                            deletefield.setVisible(false);
                            save.setVisible(true);
                            title.setText("Expense Calculator");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });

            clearbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //to clear form
                    clearform();
                }
            });

            frame.setTitle("Saksham Expenses");
            frame.setLayout(null);
            frame.setSize(500, 400);
            frame.setVisible(true);

            //to click on save button
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //insert data into database
                    insertexpenseindb();
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void clearform() {
        //to clear form after submission
        incometextfield.setText("");
        expensetypetextfield.setText("");
        expenseamounttextfield.setText("");
    }

    private static void insertexpenseindb() {
        //to insert data into table
        String insert = "insert into expense(incomeamount,expensetype,expenseamount) values(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(insert);
            ps.setInt(1, Integer.parseInt(incometextfield.getText()));
            ps.setString(2,expensetypetextfield.getText());
            ps.setInt(3, Integer.parseInt(expenseamounttextfield.getText()));
            ps.executeUpdate();

            //to pass data submission response to user

            clearform();
            JOptionPane.showMessageDialog(null, "Record has been added");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}