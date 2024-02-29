import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkpackages,
            bookpackage,
            viewpackage, viewhotels, bookhotel, viewbookedhotel, About ,destinations, payments, calculators, Logtout , membership, Destination1 ;

            static String username;
    Dashboard(String username) {
        // this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when window is closed
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 2000, 65);
        add(p1);

        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 1100);
        add(p2);

       
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 70);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new AddPersonalDetails2(username).setVisible(true);
                }
            });
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 70, 300, 70);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonalDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new EditPersonalDetails(username).setVisible(true);
                }
            });
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 140, 300, 70);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new ViewPersonalDetails(username).setVisible(true);
                }
            });
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 210, 300, 70);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        deletePersonalDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new ViewPersonalDetails(username).setVisible(true);
                }
            });
        p2.add(deletePersonalDetails);

        checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0, 280, 300, 70);
        checkpackages.setBackground(new Color(0, 0, 102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 110));
        checkpackages.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new CheckPackage(username).setVisible(true);
                }
            });
        p2.add(checkpackages);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 350, 300, 70);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 120));
        bookpackage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new bookpackage(username).setVisible(true);
                }
            });
        p2.add(bookpackage);

        
        viewpackage = new JButton("View Your Package");
        viewpackage.setBounds(0, 420, 300, 70);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 110));
        viewpackage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new viewbookedpackage(username).setVisible(true);
                }
            });
        p2.add(viewpackage);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 490, 300, 70);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 130));
        p2.add(viewhotels);

        bookhotel = new JButton("Booked Hotels");
        bookhotel.setBounds(0, 560, 300, 70);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 140));
        bookhotel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new ViewBookedHotel(username).setVisible(true);
                }
            });

        p2.add(bookhotel);

        membership = new JButton("Membership");
        membership.setBounds(0, 630, 300, 70);
        membership.setBackground(new Color(0, 0, 102));
        membership.setForeground(Color.WHITE);
        membership.setFont(new Font("Tahoma", Font.PLAIN, 20));
        membership.setMargin(new Insets(0, 0, 0, 125));
       
        p2.add(membership);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 700, 300, 70);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 125));
        destinations.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new Destination(username).setVisible(true);
                }
            });
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0, 770, 300, 70);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 155));
        payments.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new BalanceScreen(username).setVisible(true);
                }
            });
        p2.add(payments);

        About = new JButton("About");
        About.setBounds(0, 840, 300, 70);
        About.setBackground(new Color(0, 0, 102));
        About.setForeground(Color.WHITE);
        About.setFont(new Font("Tahoma", Font.PLAIN, 20));
        About.setMargin(new Insets(0, 0, 0, 155));
        About.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This line creates an instance of  and makes it visible
                    new About(username).setVisible(true);
                }
            });
        p2.add(About);

        Logtout = new JButton("Log-Out");
        Logtout.setBounds(0, 910, 300, 70);
        Logtout.setBackground(new Color(0, 0, 102));
        Logtout.setForeground(Color.red);
        Logtout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Logtout.setMargin(new Insets(0, 0, 0, 145));
        // Logtout.addActionListener(new ActionListener() {
        //         @Override
        //         public void actionPerformed(ActionEvent e) {
        //             // This line creates an instance o and makes it visible
        //             new Login(username).setVisible(true);
                    
        //         }
        //     });
        p2.add(Logtout);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        // JButton about = new JButton("About");
        // about.setBounds(0,980, 300, 70);
        // about.setBackground(new Color(0, 0, 102));
        // about.setForeground(Color.WHITE);
        // about.setFont(new Font("Tahoma", Font.PLAIN,20));
        // about.setMargin(new Insets(0, 0, 0,175));
        // p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image= new JLabel(i6);
        image.setBounds(300, 0, 1630, 1150);
        add(image);

        JLabel text = new JLabel("Yatri-Genie");
        text.setBounds(650, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.PLAIN, 70));
        image.add(text);

    


        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        // Run the dashboard
        EventQueue.invokeLater(() -> {
            new Dashboard(username).setVisible(true);
        });
    }
}
