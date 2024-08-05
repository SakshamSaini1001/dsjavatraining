package javaprojects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class railwayreservation {
    public static void main(String[] args) {
        reservation();
    }
        static void reservation()
        {
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/reservationdb";
            try {
                Connection conn = DriverManager.getConnection(url,username,password);
                System.out.println("Connected");
                JFrame frame = new JFrame();
                frame.setLayout(null);
                frame.setSize(500,700);

                JLabel title = new JLabel("Railway Reservation Form");
                title.setBounds(140,10,250,50);
                title.setFont(new Font("Calibri",Font.BOLD,20));
                frame.add(title);

                JLabel namelabel = new JLabel("Passenger Name");
                namelabel.setBounds(10,65,170,40);
                namelabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(namelabel);

                JTextField nametextfield = new JTextField();
                nametextfield.setBounds(160,70,200,30);
                frame.add(nametextfield);

                JLabel Trainnumberlabel = new JLabel("Train Number");
                Trainnumberlabel.setBounds(10,110,170,40);
                Trainnumberlabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(Trainnumberlabel);

                JTextField trainnumberfield = new JTextField();
                trainnumberfield.setBounds(160,110,200,30);
                frame.add(trainnumberfield);

                JLabel sourcelabel = new JLabel("Journey From");
                sourcelabel.setBounds(10,150,170,40);
                sourcelabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(sourcelabel);

                JTextField sourcetextfield = new JTextField();
                sourcetextfield.setBounds(160,150,200,30);
                frame.add(sourcetextfield);

                JLabel destinationlabel = new JLabel("Journey To");
                destinationlabel.setBounds(10,190,170,40);
                destinationlabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(destinationlabel);

                JTextField destinationtextfield = new JTextField();
                destinationtextfield.setBounds(160,190,200,30);
                frame.add(destinationtextfield);

                JLabel phonelabel = new JLabel("Phone Number");
                phonelabel.setBounds(10,230,170,40);
                phonelabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(phonelabel);

                JTextField phonetextfield = new JTextField();
                phonetextfield.setBounds(160,230,200,30);
                frame.add(phonetextfield);

                JLabel genderlabel = new JLabel("Gender");
                genderlabel.setBounds(10,270,170,40);
                genderlabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(genderlabel);

                JRadioButton male = new JRadioButton("Male");
                male.setBounds(160,270,100,40);
                male.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(male);

                JRadioButton female = new JRadioButton("Female");
                female.setBounds(260,270,100,40);
                female.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(female);

                JRadioButton other = new JRadioButton("Others");
                other.setBounds(360,270,100,40);
                other.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(other);

                JLabel datelabel = new JLabel("Journey Date");
                datelabel.setBounds(10,310,170,40);
                datelabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(datelabel);

                JTextField datetextfield = new JTextField();
                datetextfield.setBounds(160,310,200,30);
                frame.add(datetextfield);
                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                datetextfield.setText(dateFormat.format(currentDate));

                JLabel agelabel = new JLabel("Age");
                agelabel.setBounds(10,350,170,40);
                agelabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(agelabel);

                JTextField agetextfield = new JTextField();
                agetextfield.setBounds(160,350,200,30);
                frame.add(agetextfield);

                JLabel emaillabel = new JLabel("Email");
                emaillabel.setBounds(10,390,170,40);
                emaillabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(emaillabel);

                JTextField emailtextfield = new JTextField();
                emailtextfield.setBounds(160,390,200,30);
                frame.add(emailtextfield);

                JLabel seatlabel = new JLabel("Seat Type");
                seatlabel.setBounds(10,430,170,40);
                seatlabel.setFont(new Font("Calibri",Font.PLAIN,20));
                frame.add(seatlabel);

                String s[] = {"First AC","Second AC","Third AC","Sleeper","General"};
                JComboBox seatcombo = new JComboBox(s);
                seatcombo.setBounds(160,430,200,30);
                frame.add(seatcombo);

                JButton submitbutton = new JButton("Submit");
                submitbutton.setBounds(200,560,100,40);
                frame.add(submitbutton);

                frame.setVisible(true);

                submitbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String insert ="insert into reservation(name,trainnumber,journeyfrom,journeyto,phonenumber,gender,journeydate,age,email,seattype) values(?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = null;
                        String str = "";
                        try {
                            if(male.isSelected()){
                                 str = "Male";
                            }
                            else if(female.isSelected()){
                                 str = "Female";
                            }
                            else if(other.isSelected())
                            {
                                 str = "Other";
                            }
                            ps = conn.prepareStatement(insert);
                            ps.setString(1,nametextfield.getText());
                            ps.setInt(2,Integer.parseInt(trainnumberfield.getText()));
                            ps.setString(3,sourcetextfield.getText());
                            ps.setString(4,destinationtextfield.getText());
                            ps.setString(5, phonetextfield.getText());
                            ps.setString(6, str);
                            ps.setString(7,datetextfield.getText());
                            ps.setInt(8,Integer.parseInt(agetextfield.getText()));
                            ps.setString(9,emailtextfield.getText());
                            ps.setString(10,seatcombo.getSelectedItem().toString());
                            ps.executeUpdate();

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
