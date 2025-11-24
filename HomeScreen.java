// HomeScreen.java - MODERN PROFESSIONAL UI
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import model.Hostel;
import data.HostelDatabase;

public class HomeScreen extends JFrame {
    private JTextField searchField;
    private FilterPanel filterPanel;
    private HostelListScreen listScreen;

    public HomeScreen() {
        setTitle("StayMate - Find Your Perfect Stay");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(248, 250, 252));

        // ==================== TOP BAR ====================
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)),
                new EmptyBorder(16, 24, 16, 24)));

        JLabel title = new JLabel("StayMate");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(30, 58, 138));

        JButton profileBtn = new JButton("My Profile");
        profileBtn.setIcon(new ImageIcon(createProfileIcon()));
        profileBtn.setFont(new Font("Arial", Font.BOLD, 14));
        profileBtn.setForeground(new Color(30, 58, 138));
        profileBtn.setContentAreaFilled(false);
        profileBtn.setBorderPainted(false);
        profileBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topBar.add(title, BorderLayout.WEST);
        topBar.add(profileBtn, BorderLayout.EAST);

        // ==================== HERO SEARCH ====================
        JPanel heroPanel = new JPanel(new BorderLayout());
        heroPanel.setBackground(Color.WHITE);
        heroPanel.setBorder(new EmptyBorder(32, 48, 40, 48));

        JLabel heading = new JLabel("Find Your Perfect Hostel & Mess");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(15, 23, 42));
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel searchBox = new JPanel(new BorderLayout(12, 0));
        searchBox.setBackground(new Color(248, 250, 252));
        searchBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1, true),
                new EmptyBorder(16, 20, 16, 16)));
        searchBox.setMaximumSize(new Dimension(700, 64));

        searchField = new JTextField("Search by location, hostel name or area...");
        searchField.setFont(new Font("Arial", Font.PLAIN, 18));
        searchField.setForeground(new Color(100, 116, 139));
        searchField.setBorder(null);
        searchField.setBackground(null);

        JLabel searchIcon = new JLabel("🔍");
        searchIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));

        JButton searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("Arial", Font.BOLD, 16));
        searchBtn.setBackground(new Color(30, 58, 138));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(e -> applyFiltersAndSearch());

        searchBox.add(searchIcon, BorderLayout.WEST);
        searchBox.add(searchField, BorderLayout.CENTER);
        searchBox.add(searchBtn, BorderLayout.EAST);

        JPanel centerSearch = new JPanel();
        centerSearch.setLayout(new BorderLayout());
        centerSearch.setBackground(Color.WHITE);
        centerSearch.add(heading, BorderLayout.NORTH);
        centerSearch.add(Box.createVerticalStrut(24));
        centerSearch.add(searchBox, BorderLayout.CENTER);

        heroPanel.add(centerSearch, BorderLayout.CENTER);

        // ==================== MAIN CONTENT ====================
        final Runnable filterAction = this::applyFiltersAndSearch;
        filterPanel = new FilterPanel(filterAction);
        listScreen = new HostelListScreen(HostelDatabase.getAllHostels(), this);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(248, 250, 252));
        mainPanel.add(filterPanel, BorderLayout.WEST);
        mainPanel.add(new JScrollPane(listScreen), BorderLayout.CENTER);

        // ==================== LAYOUT ====================
        add(topBar, BorderLayout.NORTH);
        add(heroPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void applyFiltersAndSearch() {
        String query = searchField.getText().trim();
        if (query.equals("Search by location, hostel name or area...") || query.isEmpty()) {
            query = "";
        } else {
            query = query.toLowerCase();
        }

        List<Hostel> hostels = HostelDatabase.getAllHostels();
        hostels = filterPanel.applyFilters(hostels);

        if (!query.isEmpty()) {
            final String q = query;
            hostels = hostels.stream()
                    .filter(h -> h.getName().toLowerCase().contains(q) ||
                                 h.getLocation().toLowerCase().contains(q))
                    .toList();
        }

        listScreen.updateHostels(hostels);
    }

    private Image createProfileIcon() {
        int s = 40;
        BufferedImage img = new BufferedImage(s, s, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(30, 58, 138));
        g.fillOval(4, 4, s - 8, s - 8);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("U", (s - fm.stringWidth("U")) / 2, 28);
        g.dispose();
        return img;
    }
}