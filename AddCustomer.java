import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername, lblname;
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfaddress, tfcontact, tfemail;
    JRadioButton rmale, rfemale;
    JButton add, back;
    private String name;

    AddCustomer(String username) {

        setBounds(280, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox(new String[] { "Passport", "Aadhar Card", "Pan Card", "Ration card" });
        comboid.setBounds(220, 90, 150, 25);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        lblname = new JLabel();
        lblname.setBounds(220, 170, 150, 25);
        add(lblname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        lblname = new JLabel();
        lblname.setBounds(220, 170, 150, 25);
        add(lblname);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rfemale);
        bg.add(rmale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblcontact = new JLabel("Contact");
        lblcontact.setBounds(30, 330, 150, 25);
        add(lblcontact);

        tfcontact = new JTextField();
        tfcontact.setBounds(220, 330, 150, 25);
        add(tfcontact);

        JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from account where username ='" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                lblname.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = lblname.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String contact = tfcontact.getText();
            String email = tfemail.getText();

            try {
                Connect c = new Connect();
                String query = "insert into customers values ('" + username + "','" + id + "','" + number + "','" + name
                        + "','" + gender + "','" + country + "','" + address + "','" + contact + "','" + email + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Custommer Detail Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("amit");
    }
}
