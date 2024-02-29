import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DestinationScreen extends JFrame {
    private JTextArea descriptionTextArea, packageDetailsTextArea;
    private JList<String> activitiesList;
    private DefaultListModel<String> activitiesModel;

    public DestinationScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Manali Package Details");
        setSize(800, 700);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        addHeader(gbc);
        addDescriptionPanel(gbc);
        addActivitiesPanel(gbc);
        addPackageDetailsPanel(gbc);
        addBackButton(gbc);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addHeader(GridBagConstraints gbc) {
        JLabel headerLabel = new JLabel("Manali Package", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(headerLabel, gbc);
    }

    private void addDescriptionPanel(GridBagConstraints gbc) {
        descriptionTextArea = new JTextArea(20, 20);
        descriptionTextArea.setText(getDescriptionText());
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(scrollPane, gbc);
    }

    private void addActivitiesPanel(GridBagConstraints gbc) {
        activitiesModel = new DefaultListModel<>();
        activitiesList = new JList<>(activitiesModel);
        JScrollPane activitiesScrollPane = new JScrollPane(activitiesList);
        
        // Adding activities to the model
        activitiesModel.addElement("River Rafting in Beas River");
        activitiesModel.addElement("Paragliding in Solang Valley");
        activitiesModel.addElement("Trekking to Hampta Pass");
        activitiesModel.addElement("Visiting Hidimba Devi Temple");
        activitiesModel.addElement("Exploring Manali Sanctuary");
        activitiesModel.addElement("Skiing in Rohtang Pass");
        activitiesModel.addElement("Biking trip to Leh");
        activitiesModel.addElement("Vashisht Hot Water Springs Bath");
        activitiesModel.addElement("Shopping at Mall Road");
        activitiesModel.addElement("Camping and Bonfire in Kullu");
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(activitiesScrollPane, gbc);
    }

    private void addPackageDetailsPanel(GridBagConstraints gbc) {
        packageDetailsTextArea = new JTextArea(10, 20);
        packageDetailsTextArea.setText(getPackageDetailsText());
        packageDetailsTextArea.setWrapStyleWord(true);
        packageDetailsTextArea.setLineWrap(true);
        packageDetailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(packageDetailsTextArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
    }

    private void addBackButton(GridBagConstraints gbc) {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> dispose());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(backButton, gbc);
    }

    private String getDescriptionText() {
        return "Discover the enchanting beauty of Manali, nestled in the majestic Himalayas. Our comprehensive Manali package offers an unforgettable escape into the heart of nature, where the serene landscapes of snow-capped peaks, lush valleys, and the vibrant culture of the local people await you. Whether you're seeking adventure, relaxation, or a bit of both, our Manali package is designed to provide an immersive experience that caters to all your desires.";
    }

    private String getPackageDetailsText() {
        return "Package Details\n" +
                "Duration: 5 Nights / 6 Days\n" +
                "Accommodation: Choose from a variety of options, ranging from cozy homestays to luxurious resorts, all offering stunning views and excellent amenities \n"+
                "Meals: Enjoy delicious local and international cuisine, with options for vegetarians and non-vegetarians.\n"+
                "Transport: Comfortable and convenient transportation throughout your stay, including airport transfers and sightseeing tours.\n"+
                "Pricing: Starting at $499 per person. Includes accommodation, meals, guided tours, and all activity charges. Excludes airfare."
                ;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(DestinationScreen::new);
    }
}
