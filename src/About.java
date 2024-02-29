import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame {
    String username;

    public static void main(String[] args) {
        new About(" ").setVisible(true);
    }

    public About(String username) {
        this.username = username;
        setTitle("About Yatri-Genie");
        setBounds(400, 200, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel appName = new JLabel("Yatri-Genie");
        appName.setBounds(250, 20, 200, 30);
        appName.setFont(new Font("Arial", Font.BOLD, 24));
        add(appName);

        String aboutText = "<html><p align=\"center\">Yatri-Genie is a travel management application designed to simplify your travel experience. It allows users to manage their itineraries, book packages, view destinations, and much more.</p></html>";
        JLabel aboutLabel = new JLabel(aboutText);
        aboutLabel.setBounds(50, 60, 600, 100);
        aboutLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(aboutLabel);

        JLabel version = new JLabel("Version: 1.0");
        version.setBounds(50, 170, 200, 20);
        add(version);

        JLabel developers = new JLabel("Developed by: Anubhav");
        developers.setBounds(50, 200, 300, 20);
        add(developers);

        JLabel contact = new JLabel("Contact Us: email@example.com");
        contact.setBounds(50, 230, 300, 20);
        add(contact);

        JButton back = new JButton("Back");
        back.setBounds(300, 300, 100, 30);
        back.addActionListener(e -> dispose());
        add(back);

        setLocationRelativeTo(null);
    }
}
