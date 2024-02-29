import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DestinationSelectionScreen extends JFrame  implements ActionListener {
    private JList<String> destinationList;
    private DefaultListModel<String> destinationModel;
    String username;

    public DestinationSelectionScreen(String username) {
        initializeUI();
        setLocationRelativeTo(null);
    }

    private void initializeUI() {
        setTitle("Select Destination");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        destinationModel = new DefaultListModel<>();
        destinationList = new JList<>(destinationModel);
        JScrollPane scrollPane = new JScrollPane(destinationList);

        // Add some sample destinations to the model
        destinationModel.addElement("Manali");
        destinationModel.addElement("Leh Ladakh");
        destinationModel.addElement("Goa");
        destinationModel.addElement("Kerala");
        destinationModel.addElement("Rajasthan");

        destinationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add listener to handle double-click on an item
        destinationList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    String selectedDestination = destinationList.getSelectedValue();
                    openDestinationDetails(selectedDestination);
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void openDestinationDetails(String destination) {
        // Placeholder for opening destination details
        // This should ideally open a new JFrame or JPanel showing the details of the selected destination
        System.out.println("Opening details for: " + destination);
        // For demonstration, let's just open a message dialog
        JOptionPane.showMessageDialog(this, "Details for " + destination);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(DestinationSelectionScreen::new);
        new DestinationSelectionScreen(" ");
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
}
