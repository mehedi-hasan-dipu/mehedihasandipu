// HostelDetailsScreen.java
import javax.swing.*;
import java.awt.*;
import java.net.URI;
import model.Hostel;

public class HostelDetailsScreen extends JFrame {
    public HostelDetailsScreen(Hostel hostel, JFrame parent) {
        setTitle("Hostel Details - " + hostel.getName());
        setSize(800, 700);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel title = new JLabel(hostel.getName());
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        panel.add(new JLabel("<html><b>Description:</b></html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("<html>" + hostel.getDescription() + "</html>"), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Price:</b> ৳" + hostel.getPrice() + "/month</html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("<html><b>Room Type:</b> " + hostel.getRoomType() + "</html>"), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Facilities:</b></html>"), gbc);
        gbc.gridx = 1;
        String facilities = String.join(" • ", hostel.getFacilities());
        panel.add(new JLabel("<html>" + facilities + "</html>"), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Contact:</b></html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("<html>" + hostel.getContactNumber() + "<br>" + hostel.getEmail() + "</html>"), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Address:</b></html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("<html>" + hostel.getAddress() + "</html>"), gbc);

        // Buttons
        gbc.gridy++;
        gbc.gridx = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton mapBtn = createBlueButton("Open in Maps");
        mapBtn.addActionListener(e -> openMaps(hostel.getMapLink()));

        JButton chatBtn = createBlueButton("Chat with Manager");
        chatBtn.addActionListener(e -> new ChatScreen(hostel.getName()));

        JButton bookBtn = createBlueButton("Book Room");
        bookBtn.addActionListener(e -> new BookingScreen(hostel));

        JButton backBtn = new JButton("Back to Listings");
        backBtn.addActionListener(e -> dispose());

        btnPanel.add(mapBtn);
        btnPanel.add(chatBtn);
        btnPanel.add(bookBtn);
        btnPanel.add(backBtn);

        panel.add(btnPanel, gbc);

        add(new JScrollPane(panel));
        setVisible(true);
    }

    private void openMaps(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Could not open browser.");
        }
    }

    private JButton createBlueButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(0, 122, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }
}