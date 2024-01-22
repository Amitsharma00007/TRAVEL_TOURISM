import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tuserField, nameField, Tpassword, Tanswer;
    Choice tsecurity;

    SignUp() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lbusername = new JLabel("Username :");
        lbusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbusername.setBounds(50, 20, 125, 25);
        p1.add(lbusername);

        tuserField = new JTextField();
        tuserField.setBounds(150, 20, 180, 25);
        tuserField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tuserField);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setBounds(50, 60, 125, 25);
        p1.add(name);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 180, 25);
        nameField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameField);

        JLabel password = new JLabel("Password :");
        password.setFont(new Font("Tahoma", Font.BOLD, 14));
        password.setBounds(50, 100, 125, 25);
        p1.add(password);

        Tpassword = new JTextField();
        Tpassword.setBounds(150, 100, 180, 25);
        Tpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tpassword);

        JLabel security = new JLabel("Security Question:");
        security.setFont(new Font("Tahoma", Font.BOLD, 14));
        security.setBounds(50, 140, 125, 25);
        p1.add(security);

        tsecurity = new Choice();
        tsecurity.add("Fav Character from Avengers");
        tsecurity.add("GAPPU IS SMART BOY");
        tsecurity.add("JARVIS IS MADE BY ME");
        tsecurity.add("BEN 10 IS MY SUPER HERO");
        tsecurity.add("NOBITA IS CUTE BOY");
        tsecurity.add("PROJECT NHI BNAYEGA TO NO. NHI PAAYEGA");
        tsecurity.add("GAPPU BHAI KE AAGE KOI BOL SKTA HAIN");

        tsecurity.setBounds(190, 140, 180, 25);
        p1.add(tsecurity);

        JLabel answer = new JLabel("Answer :");
        answer.setFont(new Font("Tahoma", Font.BOLD, 14));
        answer.setBounds(50, 180, 125, 25);
        p1.add(answer);

        Tanswer = new JTextField();
        Tanswer.setBounds(190, 180, 180, 25);
        Tanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tanswer);

        create = new JButton("Create");
        create.setBackground(new Color(133, 191, 233));
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(new Color(133, 191, 233));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tuserField.getText();
            String name = nameField.getText();
            String password = Tpassword.getText();
            String question = tsecurity.getSelectedItem();
            String answer = Tanswer.getText();

            String query = "insert into account values('" + username + "' , '" + name +
                    "' , '" + password + "', '"
                    + question + "','" + answer + "')";
            try {
                Connect c = new Connect();
                c.s.executeUpdate(query);// dml command

                JOptionPane.showMessageDialog(null, "Account Created Succesfully");

                setVisible(false);
                new Login();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
