package javaprojects;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class railway {
    public static void main(String[] args) {
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/reservationdb";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected");
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(600,700);
        frame.setVisible(true);

        JLabel title = new JLabel("Railway Reservation Form");
        title.setBounds(140,10,250,50);
        //title.setFont(new Font("Calibri",Font.BOLD,20));
        frame.add(title);

        JLabel namelabel = new JLabel("Passenger Name");
        namelabel.setBounds(10,65,170,40);
        //namelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(namelabel);

        JTextField nametextfield = new JTextField();
        nametextfield.setBounds(160,70,200,30);
        frame.add(nametextfield);

        JLabel Trainnumberlabel = new JLabel("Train Number");
        Trainnumberlabel.setBounds(10,110,170,40);
        //Trainnumberlabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(Trainnumberlabel);

        JTextField trainnumberfield = new JTextField();
        trainnumberfield.setBounds(160,110,200,30);
        frame.add(trainnumberfield);

        JLabel sourcelabel = new JLabel("Journey From");
        sourcelabel.setBounds(10,150,170,40);
        //sourcelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(sourcelabel);

        JTextField sourcetextfield = new JTextField();
        sourcetextfield.setBounds(160,150,200,30);
        frame.add(sourcetextfield);

        JLabel destinationlabel = new JLabel("Journey To");
        destinationlabel.setBounds(10,190,170,40);
        //destinationlabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(destinationlabel);

        JTextField destinationtextfield = new JTextField();
        destinationtextfield.setBounds(160,190,200,30);
        frame.add(destinationtextfield);


    }
}
