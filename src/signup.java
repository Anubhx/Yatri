import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.PreparedStatement;


public class signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;

    signup() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0, 0, 500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblscurity= new JLabel("Security Question");
        lblscurity.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        lblscurity.setBounds(50,140,125,25);
        p1.add(lblscurity);

        security = new Choice();
        security.add("Fav Batsman in Indian Team");
        security.add("Fav Bowler in Indian Team");
        security.add("Fav Captain in Indian Team");
        security.add("Fav Team in cricket");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        JLabel lblanswer= new JLabel("Answer");
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD,16));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);

         tfanswer= new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

         create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133 ,193, 233));
        create.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);

         back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133 ,193, 233));
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(590,50,250,250);
        add(image);




        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText ();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
//             String query = "INSERT INTO account(username, name, password, security, answer) VALUES (?, ?, ?, ?, ?)";
// PreparedStatement pstmt = c.conn.prepareStatement(query);
// pstmt.setString(1, username);
// pstmt.setString(2, name);
// pstmt.setString(3, password);
// pstmt.setString(4, question);
// pstmt.setString(5, answer);
// pstmt.executeUpdate();
                 
        String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                conn c = new conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login("");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login("");
        }
    }
    public static void main(String[] args) {
        new signup();
    }
    
}