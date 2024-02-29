

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddPersonalDetails2 extends JFrame implements ActionListener {

    JLabel labelUsername, labelName;
    JComboBox<String> comboId;
    JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhone;
    JRadioButton rMale, rFemale;
    JButton add, back;
    ButtonGroup genderGroup;

    public static void main(String[] args) {
        new AddPersonalDetails2("UsernamePlaceholder").setVisible(true); // Pass actual username here
    }


    AddPersonalDetails2(String username) {
        // Window setup
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        labelUsername = new JLabel(username);
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);

        // ID
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30, 90, 150, 25);
        add(lblId);

        comboId = new JComboBox<>(new String[] { "Passport", "Aadhar Card", "Pan Card", "Ration Card" });
        comboId.setBounds(220, 90, 150, 25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        // Number
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 130, 150, 25);
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);

        // Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 170, 150, 25);
        add(lblName);

        labelName = new JLabel("Name Placeholder"); // Placeholder, set this based on actual data
        labelName.setBounds(220, 170, 150, 25);
        add(labelName);

        // Gender
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 210, 150, 25);
        add(lblGender);

        rMale = new JRadioButton("Male");
        rMale.setBounds(220, 210, 70, 25);
        rMale.setBackground(Color.WHITE);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setBounds(300, 210, 70, 25);
        rFemale.setBackground(Color.WHITE);
        add(rFemale);

        // Group the radio buttons.
        genderGroup = new ButtonGroup();
        genderGroup.add(rMale);
        genderGroup.add(rFemale);

        // Country
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 250, 150, 25);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220, 250, 150, 25);
        add(tfCountry);

        // Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 290, 150, 25);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(220, 290, 150, 25);
        add(tfAddress);

        // Phone
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 330, 150, 25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220, 330, 150, 25);
        add(tfPhone);

        // Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 370, 150, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 370, 150, 25);
        add(tfEmail);

        // Buttons
        add = new JButton("Add");
        add.setBounds(70, 430, 100, 25);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220, 430, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        JLabel detailsLabel = new JLabel("Details Screen Content");
        detailsLabel.setBounds(50, 50, 200, 30);
        add(detailsLabel);
        

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try

        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = 'shahrukh'");
    
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
            }
        }catch(
        Exception e)
        {
            e.printStackTrace();
        }

        setLocationRelativeTo(null);   

    }

   

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            // Implement logic to handle adding personal details here
            JOptionPane.showMessageDialog(null, "Add button clicked");
        } else if (ae.getSource() == back) {
            this.setVisible(false); // Hide this window
            // Alternatively, navigate back to the previous window
            JOptionPane.showMessageDialog(null, "Back button clicked");
        }
    }

}

