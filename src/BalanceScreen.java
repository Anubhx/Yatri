import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceScreen extends JFrame implements ActionListener {
    JLabel balanceLabel, usernameLabel;
    JTextField amountField;
    JButton addButton, withdrawButton, viewPurchasesButton;
    String username;

    // Constructor
    public BalanceScreen(String username) {
        this.username = username;
        setTitle("Balance Amount");
        setBounds(300, 200, 600, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username Label
        usernameLabel = new JLabel("User: " + username);
        usernameLabel.setBounds(20, 20, 200, 25);
        add(usernameLabel);

        // Balance Label
        balanceLabel = new JLabel("Balance: Fetching...");
        balanceLabel.setBounds(20, 60, 200, 25);
        add(balanceLabel);

        // Amount Field
        amountField = new JTextField();
        amountField.setBounds(20, 100, 200, 25);
        add(amountField);

        // Add Money Button
        addButton = new JButton("Add Money");
        addButton.setBounds(20, 140, 120, 25);
        addButton.addActionListener(this);
        add(addButton);

        // Withdraw Money Button
        withdrawButton = new JButton("Withdraw Money");
        withdrawButton.setBounds(150, 140, 150, 25);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        // View Purchases Button
        viewPurchasesButton = new JButton("View Purchases");
        viewPurchasesButton.setBounds(20, 180, 200, 25);
        viewPurchasesButton.addActionListener(this);
        add(viewPurchasesButton);

        // Fetch and display the balance
        fetchBalance();

        setVisible(true);
    }

    // Placeholder for fetching balance from the database
    private void fetchBalance() {
        // Assume fetching balance from the database for 'username'
        String balance = "$1000"; // Example balance
        balanceLabel.setText("Balance: " + balance);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Implement adding money logic
            JOptionPane.showMessageDialog(this, "Add Money Clicked");
        } else if (e.getSource() == withdrawButton) {
            // Implement withdrawing money logic
            JOptionPane.showMessageDialog(this, "Withdraw Money Clicked");
        } else if (e.getSource() == viewPurchasesButton) {
            // Implement viewing purchases logic
            JOptionPane.showMessageDialog(this, "View Purchases Clicked");
        }
    }

    public static void main(String[] args) {
        new BalanceScreen(""); // Example username
    }
}
