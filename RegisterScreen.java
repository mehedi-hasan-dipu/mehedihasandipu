// RegisterScreen.java
import javax.swing.*;
import java.awt.*;

public class RegisterScreen extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passField, confirmField;

    public RegisterScreen() {
        setTitle("StayMate - Register");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Create Account", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(0, 122, 255));
        gbc.gridwidth = 2; gbc.gridx = 0; gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        panel.add(new JLabel("Full Name:"), gbc);
        gbc.gridy++; nameField = new JTextField(20); panel.add(nameField, gbc);

        gbc.gridy++; panel.add(new JLabel("Email:"), gbc);
        gbc.gridy++; emailField = new JTextField(20); panel.add(emailField, gbc);

        gbc.gridy++; panel.add(new JLabel("Password:"), gbc);
        gbc.gridy++; passField = new JPasswordField(20); panel.add(passField, gbc);

        gbc.gridy++; panel.add(new JLabel("Confirm Password:"), gbc);
        gbc.gridy++; confirmField = new JPasswordField(20); panel.add(confirmField, gbc);

        gbc.gridy++;
        JButton registerBtn = new JButton("Register");
        registerBtn.setBackground(new Color(0, 122, 255));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.addActionListener(e -> register());
        panel.add(registerBtn, gbc);

        gbc.gridy++;
        JButton backBtn = new JButton("Back to Login");
        backBtn.addActionListener(e -> {
            dispose();
            new LoginScreen();
        });
        panel.add(backBtn, gbc);

        add(panel);
        setVisible(true);
    }

    private void register() {
        String pass = new String(passField.getPassword());
        String confirm = new String(confirmField.getPassword());

        if (pass.isEmpty() || !pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Registration Successful!\nWelcome to StayMate!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new HomeScreen();
    }
}