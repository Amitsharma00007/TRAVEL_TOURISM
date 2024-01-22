import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {
    JButton loginButton, signupButton, forgetButton;
    JTextField tPassword, tUsername;

    Login() {
        setSize(900, 400);
        setLocation(200, 200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lbusername = new JLabel("USERNAME");
        lbusername.setBounds(60, 20, 120, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lbusername);

        tUsername = new JTextField();
        tUsername.setBounds(60, 60, 300, 30);
        tUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tUsername);

        JLabel lpassword = new JLabel("PASSWORD");
        lpassword.setBounds(60, 110, 300, 25);
        lpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lpassword);

        tPassword = new JTextField();
        tPassword.setBounds(60, 150, 300, 30);
        tPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tPassword);

        loginButton = new JButton("Login");
        loginButton.setBounds(60, 200, 130, 30);
        loginButton.setBackground(new Color(133, 193, 233));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(new LineBorder(new Color(133, 193, 233)));
        loginButton.addActionListener(this);
        p2.add(loginButton);

        signupButton = new JButton("SignUp");
        signupButton.setBounds(230, 200, 130, 30);
        signupButton.setBackground(new Color(133, 193, 233));
        signupButton.setForeground(Color.WHITE);
        signupButton.setBorder(new LineBorder(new Color(133, 193, 233)));
        signupButton.addActionListener(this);
        p2.add(signupButton);

        forgetButton = new JButton("Forget password");
        forgetButton.setBounds(130, 250, 130, 30);
        forgetButton.setBackground(new Color(133, 193, 233));
        forgetButton.setForeground(Color.WHITE);
        forgetButton.setBorder(new LineBorder(new Color(133, 193, 233)));
        forgetButton.addActionListener(this);
        p2.add(forgetButton);

        JLabel text = new JLabel("Trouble in login....");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            try {
                String username = tUsername.getText();
                String pass = tPassword.getText();

                String query = "select * from account where username=  '" + username + "' AND password='" + pass + "'";
                Connect c = new Connect();
                c.s.executeQuery(query);
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == signupButton) {
            setVisible(false);
            new SignUp();
        } else {
            setVisible(false);
            new Forgetpassword();
        }
    }

    public static void main(String[] args) {
        new Login();// anonmous object
    }
}
