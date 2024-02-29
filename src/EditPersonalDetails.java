import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditPersonalDetails extends JFrame implements ActionListener {

    JLabel labelUsername, labelName;
    JComboBox<String> comboId;
    JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhone;
    JRadioButton rMale, rFemale;
    JButton save, back;
    ButtonGroup genderGroup;

    EditPersonalDetails(String username) {
        // Window setup
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Assume we have a method getUserDetails(username) that returns a User object with the details
        // For demonstration, using dummy data. You should fetch real data here.
        User userDetails = new User(username, "John Doe", "Passport", "A1234567", "Male", "USA", "123 Baker Street", "9876543210", "john@example.com");

        // Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        labelUsername = new JLabel(userDetails.getUsername());
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);

        // ID
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30, 90, 150, 25);
        add(lblId);

        comboId = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboId.setSelectedItem(userDetails.getIdType()); // Set selected to user's current ID type
        comboId.setBounds(220, 90, 150, 25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        // Number
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 130, 150, 25);
        add(lblNumber);

        tfNumber = new JTextField(userDetails.getIdNumber());
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);

        // Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 170, 150, 25);
        add(lblName);

        labelName = new JLabel(userDetails.getName());
        labelName.setBounds(220, 170, 150, 25);
        add(labelName);

        // Gender
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 210, 150, 25);
        add(lblGender);

        rMale = new JRadioButton("Male");
        rFemale = new JRadioButton("Female");
        rMale.setBackground(Color.WHITE);
        rFemale.setBackground(Color.WHITE);

        if("Male".equals(userDetails.getGender())) {
            rMale.setSelected(true);
        } else {
            rFemale.setSelected(true);
        }

        rMale.setBounds(220, 210, 70, 25);
        rFemale.setBounds(300, 210, 70, 25);

        genderGroup = new ButtonGroup();
        genderGroup.add(rMale);
        genderGroup.add(rFemale);

        add(rMale);
        add(rFemale);

        // Country
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 250, 150, 25);
        add(lblCountry);

        tfCountry = new JTextField(userDetails.getCountry());
        tfCountry.setBounds(220, 250, 150, 25);
        add(tfCountry);

        // Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 290, 150, 25);
        add(lblAddress);

        tfAddress = new JTextField(userDetails.getAddress());
        tfAddress.setBounds(220, 290, 150, 25);
        add(tfAddress);

        // Phone
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 330, 150, 25);
        add(lblPhone);

        tfPhone = new JTextField(userDetails.getPhone());
        tfPhone.setBounds(220, 330, 150, 25);
        add(tfPhone);

        // Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 370, 150, 25);
        add(lblEmail);

        tfEmail = new JTextField(userDetails.getEmail());
        tfEmail.setBounds(220, 370, 150, 25);
        add(tfEmail);

        // Save Button
        save = new JButton("Save");
        save.setBounds(70, 430, 100, 25);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);

        // Back Button
        back = new JButton("Back");
        back.setBounds(220, 430, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            // Implement logic to update user details here
            JOptionPane.showMessageDialog(null, "Save button clicked");
        } else if (e.getSource() == back) {
            this.setVisible(false);
            // Optionally, navigate back to the previous window
            JOptionPane.showMessageDialog(null, "Back button clicked");
        }
    }

    public static void main(String[] args) {
        new EditPersonalDetails("UsernamePlaceholder").setVisible(true);
    }
    
    // Dummy User class to support the above constructor
    class User {
        private String username, name, idType, idNumber, gender, country, address, phone, email;

        public User(String username, String name, String idType, String idNumber, String gender, String country, String address, String phone, String email) {
            this.username = username;
            this.name = name;
            this.idType = idType;
            this.idNumber = idNumber;
            this.gender = gender;
            this.country = country;
            this.address = address;
            this.phone = phone;
            this.email = email;
        }

        // Getters
        public String getUsername() { return username; }
        public String getName() { return name; }
        public String getIdType() { return idType; }
        public String getIdNumber() { return idNumber; }
        public String getGender() { return gender; }
        public String getCountry() { return country; }
        public String getAddress() { return address; }
        public String getPhone() { return phone; }
        public String getEmail() { return email; }
    }
}

