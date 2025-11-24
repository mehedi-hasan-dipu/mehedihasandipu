// BookingScreen.java
import javax.swing.*;
import java.awt.*;
import model.Hostel;

public class BookingScreen extends JFrame {
    public BookingScreen(Hostel hostel) {
        setTitle("Confirm Booking");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        JLabel title = new JLabel("Confirm Your Booking");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        panel.add(new JLabel("<html><b>Hostel:</b></html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(hostel.getName()), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Room Type:</b></html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(hostel.getRoomType()), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Price:</b></html>"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("৳" + hostel.getPrice() + "/month"), gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("<html><b>Your Name:</b></html>"), gbc);
        gbc.gridx = 1;
        JTextField nameField = new JTextField("Rahim Khan");
        nameField.setPreferredSize(new Dimension(200, 30));
        panel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.gridx = 0;

        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton confirm = new JButton("Confirm Booking");
        confirm.setBackground(new Color(0, 180, 0));
        confirm.setForeground(Color.WHITE);
        confirm.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Booking confirmed successfully!\nHostel: " + hostel.getName() +
                "\nWe'll contact you soon at " + hostel.getContactNumber(),
                "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> dispose());

        btnPanel.add(confirm);
        btnPanel.add(cancel);
        panel.add(btnPanel, gbc);

        add(panel);
        setVisible(true);
    }
}