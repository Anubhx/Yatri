import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    // Hide the Loading screen
                    setVisible(false);
                    // Open the Dashboard screen
                    new Dashboard(username);
                    break; // Break the loop once the Dashboard screen is opened
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Yatri-Genie");
        text.setBounds(220, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Poppins", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Railways", Font.BOLD, 16));
        add(loading);

        JLabel lblusername = new JLabel(" Welcome " + username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Railways", Font.BOLD, 16));
        add(lblusername);

        t.start();

        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("UsernamePlaceholder");
    }
}
