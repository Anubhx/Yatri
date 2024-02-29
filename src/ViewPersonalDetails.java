import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewPersonalDetails extends JFrame implements ActionListener {
    JLabel labelUsername, labelName, labelId, labelNumber, labelGender, labelCountry, labelAddress, labelPhone, labelEmail;
    JButton editDetails,Delete, back;
    String username;

    // Constructor
    ViewPersonalDetails(String username) {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Assume we have a method getUserDetails(username) that returns a User object with the details
        User userDetails = getUserDetails(username); // You need to implement this method

        // Username
        labelUsername = new JLabel("Username: " + userDetails.getUsername());
        labelUsername.setBounds(30, 50, 300, 25);
        add(labelUsername);

        // Name
        labelName = new JLabel("Name: " + userDetails.getName());
        labelName.setBounds(30, 90, 300, 25);
        add(labelName);

        // ID - Assuming you have an ID type and number
        labelId = new JLabel("ID: " + userDetails.getIdType() + " - " + userDetails.getIdNumber());
        labelId.setBounds(30, 130, 300, 25);
        add(labelId);

        // Gender
        labelGender = new JLabel("Gender: " + userDetails.getGender());
        labelGender.setBounds(30, 170, 300, 25);
        add(labelGender);

        // Country
        labelCountry = new JLabel("Country: " + userDetails.getCountry());
        labelCountry.setBounds(30, 210, 300, 25);
        add(labelCountry);

        // Address
        labelAddress = new JLabel("Address: " + userDetails.getAddress());
        labelAddress.setBounds(30, 250, 300, 25);
        add(labelAddress);

        // Phone
        labelPhone = new JLabel("Phone: " + userDetails.getPhone());
        labelPhone.setBounds(30, 290, 300, 25);
        add(labelPhone);

        // Email
        labelEmail = new JLabel("Email: " + userDetails.getEmail());
        labelEmail.setBounds(30, 330, 300, 25);
        add(labelEmail);

        // Edit Details Button
        editDetails = new JButton("Edit Details");
        editDetails.setBounds(70, 430, 150, 25);
        editDetails.setBackground(Color.BLACK);
        editDetails.setForeground(Color.WHITE);
        editDetails.addActionListener(this);
        add(editDetails);

        // Back Button
        back = new JButton("Back");
        back.setBounds(230, 430, 150, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        Delete = new JButton("Delete");
        Delete.setBounds(155, 470, 150, 25);
        Delete.setBackground(Color.RED);
        Delete.setForeground(Color.WHITE);
        Delete.addActionListener(this);
        add(Delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ViewPersonalDetails("UsernamePlaceholder").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Delete) {
            // Show a confirmation dialog
            int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete your details?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Check the user's response
            if (response == JOptionPane.YES_OPTION) {
                // User clicked "Yes" - proceed with deletion
                try {
                    conn c = new conn();
                    String query = "DELETE FROM account WHERE username = ('" + username + "')"; // Use your actual logic to determine the correct query
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
                    setVisible(false);
                    new Login(); // Navigate the user back to the login screen or another appropriate screen
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting account");
                }
            } else if (response == JOptionPane.NO_OPTION) {
                // User clicked "No" - do nothing, just return from the method
                return;
            }
        }
        if (e.getSource() == editDetails) {
            // Open edit details screen
            JOptionPane.showMessageDialog(null, "Edit button clicked");
            // You can open an editing screen here
        } else if (e.getSource() == back) {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Back button clicked");
        }
    }

    // Dummy method to simulate retrieving user details
    private User getUserDetails(String username) {
        // This method should retrieve user details from a data source
        // Returning a dummy user object for demonstration
        return new User(username, "Name", "ID Type", "ID Number", "Male", "Country", "Address", "Phone", "Email");
    }

    // Dummy User class to support the above method
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
