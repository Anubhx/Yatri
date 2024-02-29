import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.function.Consumer;


// Main Frame for Destination and Activities Management
public class DestinationActivitiesUI extends JFrame {

    private DestinationPanel destinationPanel;
    private ActivitiesPanel activitiesPanel;
    private ActivityDetailsPanel activityDetailsPanel;

    public DestinationActivitiesUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Destinations and Activities Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        destinationPanel = new DestinationPanel(this::onDestinationSelected);
        activitiesPanel = new ActivitiesPanel(this::onActivitySelected);
        activityDetailsPanel = new ActivityDetailsPanel();

        add(destinationPanel, BorderLayout.WEST);
        add(activitiesPanel, BorderLayout.CENTER);
        add(activityDetailsPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null); // Center on screen
    }

    private void onDestinationSelected(String destination) {
        activitiesPanel.loadActivitiesForDestination(destination);
    }

    private void onActivitySelected(String activity) {
        activityDetailsPanel.loadActivityDetails(activity);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DestinationActivitiesUI frame = new DestinationActivitiesUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

// Panel for selecting destinations
class DestinationPanel extends JPanel {
    private DefaultListModel<String> destinationsModel;
    private JList<String> destinationsList;
    private Consumer<String> onDestinationSelected;

    public DestinationPanel(Consumer<String> onDestinationSelected) {
        this.onDestinationSelected = onDestinationSelected;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));
        createUI();
    }

    private void createUI() {
        destinationsModel = new DefaultListModel<>();
        destinationsList = new JList<>(destinationsModel);
        destinationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        destinationsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedDestination = destinationsList.getSelectedValue();
                onDestinationSelected.accept(selectedDestination);
            }
        });
        add(new JScrollPane(destinationsList), BorderLayout.CENTER);
        loadDestinations();
    }

    private void loadDestinations() {
        // Placeholder: Load destinations from a database or service
        destinationsModel.addElement("Destination 1");
        destinationsModel.addElement("Destination 2");
    }
}

// Panel for displaying activities of the selected destination
class ActivitiesPanel extends JPanel {
    private DefaultListModel<String> activitiesModel;
    private JList<String> activitiesList;
    private Consumer<String> onActivitySelected;

    public ActivitiesPanel(Consumer<String> onActivitySelected) {
        this.onActivitySelected = onActivitySelected;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));
        createUI();
    }

    private void createUI() {
        activitiesModel = new DefaultListModel<>();
        activitiesList = new JList<>(activitiesModel);
        activitiesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        activitiesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedActivity = activitiesList.getSelectedValue();
                onActivitySelected.accept(selectedActivity);
            }
        });
        add(new JScrollPane(activitiesList), BorderLayout.CENTER);
    }

    public void loadActivitiesForDestination(String destination) {
        // Placeholder: Load activities based on the selected destination
        activitiesModel.clear(); // Clear previous items
        activitiesModel.addElement("Activity 1");
        activitiesModel.addElement("Activity 2");
    }
}

// Panel for displaying details of the selected activity
class ActivityDetailsPanel extends JPanel {
    private JTextArea detailsTextArea;

    public ActivityDetailsPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 0));
        createUI();
    }

    private void createUI() {
        detailsTextArea = new JTextArea("Activity Details...");
        detailsTextArea.setEditable(false);
        add(new JScrollPane(detailsTextArea), BorderLayout.CENTER);
    }

    public void loadActivityDetails(String activity) {
        // Placeholder: Load and display details of the selected activity
        detailsTextArea.setText("Details for " + activity + "\nMore details here...");
    }
}
