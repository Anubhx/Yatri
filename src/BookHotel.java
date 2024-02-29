import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    JTextField t1, t2;
    Choice c1, c2, c3;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookHotel frame = new BookHotel("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookHotel(String username) {
        setBounds(420, 220, 1100, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 100, 700, 300);
        add(la1);

        JLabel lblName = new JLabel("BOOK HOTEL");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from hotels");
            while (rs.next()) {
                c1.add(rs.getString("name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 110, 150, 30);
        add(c1);

        // Additional UI setup code here...

        getContentPane().setBackground(Color.WHITE);
    }
}
