import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Forgetpassword extends JFrame implements ActionListener {
    JTextField tfusername, tname, tquestion, tanswer, tpassword;
    JButton search, retrieve, back;

    Forgetpassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 60, 100, 25);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(name);

        tname = new JTextField();
        tname.setBounds(220, 60, 150, 25);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tname);

        JLabel question = new JLabel("Security Question");
        question.setBounds(40, 100, 150, 25);
        question.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(question);

        tquestion = new JTextField();
        tquestion.setBounds(220, 100, 150, 25);
        tquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tquestion);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(40, 140, 150, 25);
        answer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(answer);

        tanswer = new JTextField();
        tanswer.setBounds(220, 140, 150, 25);
        tanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 180, 150, 25);
        password.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(password);

        tpassword = new JTextField();
        tpassword.setBounds(220, 180, 150, 25);
        tpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tpassword);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            try {
                String query = "select * from account where username ='" + tfusername.getText() + "'";
                Connect c = new Connect();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tname.setText(rs.getString("name"));
                    tquestion.setText(rs.getString("security"));
                }

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == retrieve) {
            try {
                String query = "select * from account where answer ='" + tanswer.getText() + "' AND username='"
                        + tfusername.getText() + "'";
                Connect c = new Connect();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tpassword.setText(rs.getString("password"));

                }

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Forgetpassword();
    }
}
