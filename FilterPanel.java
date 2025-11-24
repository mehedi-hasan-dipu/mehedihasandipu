// FilterPanel.java - FIXED & PROFESSIONAL UI
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Hostel;

public class FilterPanel extends JPanel {
    private JTextField minPrice, maxPrice;
    private JComboBox<String> roomType, gender, location;
    private Runnable onApply;

    public FilterPanel(Runnable onApply) {
        this.onApply = onApply;
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(228, 228, 228)),
                new EmptyBorder(32, 32, 32, 32)));
        setPreferredSize(new Dimension(320, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Filters");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(15, 23, 42));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createVerticalStrut(24));

        add(createSection("Price Range (BDT)"));
        minPrice = createTextField("Min Price");
        maxPrice = createTextField("Max Price");
        add(minPrice);
        add(Box.createVerticalStrut(8));
        add(maxPrice);

        add(Box.createVerticalStrut(24));
        add(createSection("Room Type"));
        roomType = new JComboBox<>(new String[]{"Any", "Single", "Double", "Shared"});
        styleComboBox(roomType);  // Fixed line
        add(roomType);

        add(Box.createVerticalStrut(24));
        add(createSection("Gender"));
        gender = new JComboBox<>(new String[]{"Any", "Male", "Female"});
        styleComboBox(gender);    // Fixed line
        add(gender);

        add(Box.createVerticalStrut(24));
        add(createSection("Location"));
        location = new JComboBox<>(new String[]{
                "Any", "Dhanmondi", "Mirpur", "Uttara", "Gulshan",
                "Banani", "Bashundhara", "Mohakhali", "Lalmatia"
        });
        styleComboBox(location);  // Fixed line
        add(location);

        add(Box.createVerticalStrut(40));

        JButton applyBtn = new JButton("Apply Filters");
        applyBtn.setFont(new Font("Arial", Font.BOLD, 16));
        applyBtn.setBackground(new Color(30, 58, 138));
        applyBtn.setForeground(Color.WHITE);
        applyBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 56));
        applyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        applyBtn.addActionListener(e -> onApply.run());
        add(applyBtn);
    }

    private JLabel createSection(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(new Color(51, 65, 85));
        return label;
    }

    private JTextField createTextField(String placeholder) {
        JTextField field = new JTextField(placeholder);
        field.setFont(new Font("Arial", Font.PLAIN, 16));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                new EmptyBorder(0, 12, 0, 12)));
        return field;
    }

    // This method was missing the correct name
    private void styleComboBox(JComboBox<?> combo) {
        combo.setFont(new Font("Arial", Font.PLAIN, 16));
        combo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        combo.setBackground(Color.WHITE);
    }

    public List<Hostel> applyFilters(List<Hostel> hostels) {
        List<Hostel> filtered = new ArrayList<>(hostels);

        try {
            int min = minPrice.getText().isEmpty() ? 0 : Integer.parseInt(minPrice.getText());
            int max = maxPrice.getText().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(maxPrice.getText());
            filtered = filtered.stream()
                    .filter(h -> h.getPrice() >= min && h.getPrice() <= max)
                    .toList();
        } catch (Exception ignored) {}

        String rt = (String) roomType.getSelectedItem();
        if (!"Any".equals(rt)) {
            filtered = filtered.stream().filter(h -> h.getRoomType().equals(rt)).toList();
        }

        String gen = (String) gender.getSelectedItem();
        if (!"Any".equals(gen)) {
            filtered = filtered.stream().filter(h -> h.getGenderType().equals(gen)).toList();
        }

        String loc = (String) location.getSelectedItem();
        if (!"Any".equals(loc)) {
            filtered = filtered.stream().filter(h -> h.getLocation().equals(loc)).toList();
        }

        return filtered;
    }
}