import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static JTextField firstnamefield;
    static JTextField lastnamefield;
    static JTextField emailfield;
    static JTextField phonefield;
    static JTextField addressfield1;
    static JTextField cityfield;
    static JTextField statefield;
    static JTextField postalcodefield;
    static JTextField checkindatefield;
    static JTextField checkintimefield;
    static JTextField checkouttimefield;
    static JTextField checkoutdatefield;
    static JComboBox categorycombo;
    static JComboBox adultcombo;
    static JComboBox childrencombo;
    static JButton submit;
    static JButton reset;
    public static void main(String[] args) {
        //MongoClient client = MongoClients.create("mongodb://localhost:27017");
        design();
        reset();
    }
    private static void design() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(600,800);

        JLabel title = new JLabel("Hotel Booking System");
        title.setBounds(185,10,230,50);
        title.setFont(new Font("Calibri",Font.BOLD,25));
        frame.add(title);

        JLabel firstnamelabel = new JLabel("First Name");
        firstnamelabel.setBounds(20,60,120,50);
        firstnamelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(firstnamelabel);

        firstnamefield = new JTextField();
        firstnamefield.setBounds(20,100,200,30);
        firstnamefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(firstnamefield);

        JLabel lastnamelabel = new JLabel("Last Name");
        lastnamelabel.setBounds(300,60,100,50);
        lastnamelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(lastnamelabel);

        lastnamefield = new JTextField();
        lastnamefield.setBounds(300,100,200,30);
        lastnamefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(lastnamefield);

        JLabel addresslabel1 = new JLabel("Address");
        addresslabel1.setBounds(20,140,170,50);
        addresslabel1.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(addresslabel1);

        addressfield1 = new JTextField();
        addressfield1.setBounds(20,180,200,30);
        addressfield1.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(addressfield1);

        JLabel citylabel = new JLabel("City");
        citylabel.setBounds(300,140,170,50);
        citylabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(citylabel);

        cityfield = new JTextField();
        cityfield.setBounds(300,180,200,30);
        cityfield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(cityfield);

        JLabel postalcodelabel = new JLabel("Postal Code");
        postalcodelabel.setBounds(300,220,170,50);
        postalcodelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(postalcodelabel);

        postalcodefield = new JTextField();
        postalcodefield.setBounds(300,260,200,30);
        postalcodefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(postalcodefield);

        JLabel statelabel = new JLabel("State");
        statelabel.setBounds(20,220,170,50);
        statelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(statelabel);

        statefield = new JTextField();
        statefield.setBounds(20,260,200,30);
        statefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(statefield);

        JLabel phonelabel = new JLabel("Phone Number");
        phonelabel.setBounds(20,300,170,50);
        phonelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(phonelabel);

        phonefield = new JTextField();
        phonefield.setBounds(20,340,200,30);
        phonefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(phonefield);

        JLabel emaillabel = new JLabel("Email");
        emaillabel.setBounds(300,300,170,50);
        emaillabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(emaillabel);

        emailfield = new JTextField();
        emailfield.setBounds(300,340,200,30);
        emailfield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(emailfield);

        JLabel checkindatelabel = new JLabel("Check In Date");
        checkindatelabel.setBounds(20,380,170,50);
        checkindatelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(checkindatelabel);

        checkindatefield = new JTextField();
        checkindatefield.setBounds(20,420,200,30);
        checkindatefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(checkindatefield);

        JLabel checkintimelabel = new JLabel("Check In Time");
        checkintimelabel.setBounds(300,380,170,50);
        checkintimelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(checkintimelabel);

        checkintimefield = new JTextField();
        checkintimefield.setBounds(300,420,200,30);
        checkintimefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(checkintimefield);

        JLabel checkoutdatelabel = new JLabel("Check Out Date");
        checkoutdatelabel.setBounds(20,460,170,50);
        checkoutdatelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(checkoutdatelabel);

        checkoutdatefield = new JTextField();
        checkoutdatefield.setBounds(20,500,200,30);
        checkoutdatefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(checkoutdatefield);

        JLabel checkouttimelabel = new JLabel("Check Out Time");
        checkouttimelabel.setBounds(300,460,170,50);
        checkouttimelabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(checkouttimelabel);

        checkouttimefield = new JTextField();
        checkouttimefield.setBounds(300,500,200,30);
        checkouttimefield.setFont(new Font("Calibri",Font.PLAIN,15));
        frame.add(checkouttimefield);

        JLabel adultlabel = new JLabel("No. of Adults");
        adultlabel.setBounds(20,540,170,50);
        adultlabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(adultlabel);

        String s[] = {"0","1","2","3","4"};
        adultcombo = new JComboBox(s);
        adultcombo.setBounds(20,580,170,30);
        frame.add(adultcombo);

        JLabel childrenlabel = new JLabel("No. of Children");
        childrenlabel.setBounds(210,540,170,50);
        childrenlabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(childrenlabel);

        childrencombo = new JComboBox(s);
        childrencombo.setBounds(210,580,170,30);
        frame.add(childrencombo);

        JLabel categorylabel = new JLabel("Category");
        categorylabel.setBounds(400,540,170,50);
        categorylabel.setFont(new Font("Calibri",Font.PLAIN,20));
        frame.add(categorylabel);

        String category[] = {"Normal","Deluxe","Suite"};
        categorycombo = new JComboBox(category);
        categorycombo.setBounds(400,580,170,30);
        frame.add(categorycombo);

        submit = new JButton("SUBMIT");
        submit.setBounds(50,700,230,50);
        frame.add(submit);

        reset = new JButton("RESET");
        reset.setBounds(320,700,230,50);
        frame.add(reset);

        frame.setVisible(true);
        working();
    }

    private static void working() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var client = MongoClients.create("mongodb://localhost:27017");

                var database = client.getDatabase("hotelbookingdb");
                //database.createCollection("reservationcollection");
                var collection = database.getCollection("reservationcollection");
                System.out.println(database.getName());
                var document = new Document();
                Random random = new Random();
                document.append("Reservation ID", random.nextInt(999999));
                document.append("First Name",firstnamefield.getText());
                document.append("Last Name",lastnamefield.getText());
                document.append("Email",emailfield.getText());
                document.append("Mobile Number",phonefield.getText());
                document.append("Address",addressfield1.getText());
                document.append("City",cityfield.getText());
                document.append("State",statefield.getText());
                document.append("Check In Date",checkindatefield.getText());
                document.append("Check In Time",checkintimefield.getText());
                document.append("Check Out Date",checkoutdatefield.getText());
                document.append("Check Out Time",checkouttimefield.getText());
                document.append("Number of Adults",adultcombo.getSelectedItem());
                document.append("Number of Children",childrencombo.getSelectedItem());
                document.append("Category", categorycombo.getSelectedItem().toString());

                collection.insertOne(document);

                reset.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reset();
                    }
                });
            }
        });
    }
    private static void reset() {
        firstnamefield.setText("");
        lastnamefield.setText("");
        emailfield.setText("");
        phonefield.setText("");
        addressfield1.setText("");
        cityfield.setText("");
        statefield.setText("");
        postalcodefield.setText("");
        checkindatefield.setText("");
        checkintimefield.setText("");
        checkoutdatefield.setText("");
        checkouttimefield.setText("");
    }
}