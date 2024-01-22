import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {

    Thread thread1;
    JProgressBar bar;
    String username;

    // @Override
    public void run() {
        try {
            int maxValue = bar.getMaximum();

            while (true) {
                int currentValue = bar.getValue();

                // if the loading is complete
                if (currentValue >= maxValue) {
                    setVisible(false);
                    new Dashboard(username);
                    break;
                }

                bar.setValue(currentValue + 1);
                Thread.sleep(50);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        thread1 = new Thread(this);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.MAGENTA);
        text.setFont(new Font("Railway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading Please Wait...");
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Railway", Font.BOLD, 16));
        add(loading);

        JLabel lusername = new JLabel("Welcome " + username);
        lusername.setBounds(20, 310, 400, 40);
        lusername.setForeground(Color.MAGENTA);
        lusername.setFont(new Font("Railway", Font.BOLD, 16));
        add(lusername);

        thread1.start();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Loading("");
    }
}
