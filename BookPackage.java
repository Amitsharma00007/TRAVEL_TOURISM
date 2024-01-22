import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfperson;
    String username;
    JLabel labelusername, labelnumber, labelcontact, labelprice, labelid;
    JButton checkprice, bookpackage, back;

    BookPackage(String username) {
        this.username = username;
        setBounds(150, 100, 1100, 500);
        setLayout(null);

        JLabel lblbookpackage = new JLabel("BOOK PACKAGE");
        lblbookpackage.setBounds(100, 10, 200, 30);
        lblbookpackage.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblbookpackage);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 100, 20);
        add(labelusername);

        JLabel lblselect = new JLabel("Select Package");
        lblselect.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblselect.setBounds(40, 110, 150, 20);
        add(lblselect);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 100, 20);
        add(cpackage);

        JLabel lblperson = new JLabel("Total Person");
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblperson.setBounds(40, 150, 150, 25);
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);

        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 190, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 230, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        JLabel lblcontact = new JLabel("Contact");
        lblcontact.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcontact.setBounds(40, 270, 150, 25);
        add(lblcontact);

        labelcontact = new JLabel();
        labelcontact.setBounds(250, 270, 150, 25);
        add(labelcontact);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(40, 310, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
        add(labelprice);

        try {
            Connect c = new Connect();
            String query = "select * from customers where  username='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelcontact.setText(rs.getString("Contact"));
                // labelprice.setText(rs.getString("Total Price"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 150000;
            } else if (pack.equals("Silver Package")) {
                cost += 100000;
            } else {
                cost += 50000;
            }

            int person = Integer.parseInt(tfperson.getText());
            cost *= person;
            labelprice.setText("$" + cost);

        } else if (ae.getSource() == bookpackage) {
            try {
                Connect c = new Connect();
                c.s.executeUpdate("insert into bookpackage values('" + labelusername.getText() + "','"
                        + cpackage.getSelectedItem() + "','" + tfperson.getText() + "','" + labelid.getText() + "','"
                        + labelnumber.getText() + "','" + labelcontact.getText() + "','" + labelprice.getText()
                        + "')");

                JOptionPane.showMessageDialog(null, "Packaged Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("amit");
    }
}
