import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addpersonalDetails, viewpersonalDetails, updatepersonalDetails, checkPackages, bookPackage;

    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addpersonalDetails = new JButton("Add Personal Detail ");
        addpersonalDetails.setBounds(0, 0, 300, 50);
        addpersonalDetails.setBackground(new Color(0, 0, 102));
        addpersonalDetails.setForeground(Color.WHITE);
        addpersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addpersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addpersonalDetails.addActionListener(this);
        p2.add(addpersonalDetails);

        updatepersonalDetails = new JButton("Update Personal Detail ");
        updatepersonalDetails.setBounds(0, 40, 300, 50);
        updatepersonalDetails.setBackground(new Color(0, 0, 102));
        updatepersonalDetails.setForeground(Color.WHITE);
        updatepersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatepersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        updatepersonalDetails.addActionListener(this);
        p2.add(updatepersonalDetails);

        viewpersonalDetails = new JButton("View Detail");
        viewpersonalDetails.setBounds(0, 80, 300, 50);
        viewpersonalDetails.setBackground(new Color(0, 0, 102));
        viewpersonalDetails.setForeground(Color.WHITE);
        viewpersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpersonalDetails.setMargin(new Insets(0, 0, 0, 150));
        viewpersonalDetails.addActionListener(this);
        p2.add(viewpersonalDetails);

        JButton deletepersonalDetail = new JButton("Delete Personal Detail ");
        deletepersonalDetail.setBounds(0, 120, 300, 50);
        deletepersonalDetail.setBackground(new Color(0, 0, 102));
        deletepersonalDetail.setForeground(Color.WHITE);
        deletepersonalDetail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletepersonalDetail.setMargin(new Insets(0, 0, 0, 50));
        p2.add(deletepersonalDetail);

        checkPackages = new JButton("Check Package ");
        checkPackages.setBounds(0, 160, 300, 50);
        checkPackages.setBackground(new Color(0, 0, 102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0, 0, 0, 115));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage = new JButton("Book Package ");
        bookPackage.setBounds(0, 200, 300, 50);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackage.setMargin(new Insets(0, 0, 0, 125));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        JButton viewPackage = new JButton("View Package ");
        viewPackage.setBounds(0, 240, 300, 50);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackage.setMargin(new Insets(0, 0, 0, 125));
        p2.add(viewPackage);

        JButton viewhotels = new JButton("View Hotels ");
        viewhotels.setBounds(0, 280, 300, 50);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 145));
        p2.add(viewhotels);

        JButton bookhotels = new JButton("Book Hotels ");
        bookhotels.setBounds(0, 320, 300, 50);
        bookhotels.setBackground(new Color(0, 0, 102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotels.setMargin(new Insets(0, 0, 0, 145));
        p2.add(bookhotels);

        JButton viewbookhotels = new JButton("View Book Hotels ");
        viewbookhotels.setBounds(0, 360, 300, 50);
        viewbookhotels.setBackground(new Color(0, 0, 102));
        viewbookhotels.setForeground(Color.WHITE);
        viewbookhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookhotels.setMargin(new Insets(0, 0, 0, 100));
        p2.add(viewbookhotels);

        JButton destination = new JButton("Destination");
        destination.setBounds(0, 400, 300, 50);
        destination.setBackground(new Color(0, 0, 102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destination.setMargin(new Insets(0, 0, 0, 160));
        p2.add(destination);

        JButton payments = new JButton("Payments");
        payments.setBounds(0, 440, 300, 50);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 170));
        p2.add(payments);

        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0, 440, 300, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 160));
        p2.add(calculator);

        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0, 480, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 180));
        p2.add(notepad);

        JButton about = new JButton("About");
        about.setBounds(0, 530, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 200));
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(5, 0, 1450, 800);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1000, 70);
        text.setForeground(Color.YELLOW);
        text.setFont(new Font("Railway", Font.PLAIN, 40));
        image.add(text);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addpersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewpersonalDetails) {
            new ViewCustomer(username);
        } else if (ae.getSource() == updatepersonalDetails) {
            new UpdateCustomer("username");
        } else if (ae.getSource() == checkPackages) {
            new CheckPackages();
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
