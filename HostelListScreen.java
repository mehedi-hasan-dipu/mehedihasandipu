// HostelListScreen.java - FIXED & PROFESSIONAL UI
import javax.swing.*;
import javax.swing.border.EmptyBorder;   // THIS WAS MISSING!
import java.awt.*;
import model.Hostel;

public class HostelListScreen extends JPanel {
    private HomeScreen parent;

    public HostelListScreen(java.util.List<Hostel> hostels, HomeScreen parent) {
        this.parent = parent;
        setLayout(new GridLayout(0, 3, 24, 24));
        setBackground(new Color(248, 250, 252));
        setBorder(new EmptyBorder(32, 48, 32, 48));  // Now works perfectly
        updateHostels(hostels);
    }

    public void updateHostels(java.util.List<Hostel> hostels) {
        removeAll();
        if (hostels.isEmpty()) {
            JLabel noResult = new JLabel("No hostels found. Try adjusting filters.", SwingConstants.CENTER);
            noResult.setFont(new Font("Arial", Font.PLAIN, 18));
            noResult.setForeground(new Color(100, 116, 139));
            add(noResult);
        } else {
            for (Hostel h : hostels) {
                add(createModernCard(h));
            }
        }
        revalidate();
        repaint();
    }

    private JPanel createModernCard(Hostel h) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(228, 228, 228)),
                new EmptyBorder(24, 24, 24, 24)));
        card.setPreferredSize(new Dimension(360, 240));

        JLabel name = new JLabel(h.getName());
        name.setFont(new Font("Arial", Font.BOLD, 22));
        name.setForeground(new Color(15, 23, 42));

        JLabel location = new JLabel("Location: " + h.getLocation());
        location.setFont(new Font("Arial", Font.PLAIN, 16));
        location.setForeground(new Color(100, 116, 139));

        JTextArea desc = new JTextArea(h.getDescription());
        desc.setFont(new Font("Arial", Font.PLAIN, 15));
        desc.setForeground(new Color(71, 85, 105));
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setEditable(false);
        desc.setBackground(null);
        desc.setBorder(null);

        JLabel price = new JLabel("৳" + h.getPrice() + "/month");
        price.setFont(new Font("Arial", Font.BOLD, 20));
        price.setForeground(new Color(16, 185, 129));

        JLabel type = new JLabel(h.getRoomType() + " Room • " + h.getGenderType());
        type.setFont(new Font("Arial", Font.PLAIN, 14));
        type.setForeground(new Color(148, 163, 184));

        JButton viewBtn = new JButton("View Details");
        viewBtn.setFont(new Font("Arial", Font.BOLD, 15));
        viewBtn.setBackground(new Color(30, 58, 138));
        viewBtn.setForeground(Color.WHITE);
        viewBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewBtn.setFocusPainted(false);
        viewBtn.addActionListener(e -> new HostelDetailsScreen(h, parent));

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBackground(Color.WHITE);
        info.setBorder(new EmptyBorder(0, 0, 16, 0));
        info.add(name);
        info.add(Box.createVerticalStrut(8));
        info.add(location);
        info.add(Box.createVerticalStrut(12));
        info.add(desc);
        info.add(Box.createVerticalStrut(12));
        info.add(type);
        info.add(Box.createVerticalStrut(16));
        info.add(price);

        card.add(info, BorderLayout.CENTER);
        card.add(viewBtn, BorderLayout.SOUTH);

        return card;
    }
}