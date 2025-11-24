// LoginScreen.java
import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("StayMate - Login");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Welcome!", SwingConstants.CENTER);
        title.setFont(new Font("Inter", Font.BOLD, 28));
        title.setForeground(new Color(0, 122, 255));

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        panel.add(new JLabel("Enter e-mail:"), gbc);
        gbc.gridy++;
        emailField = new JTextField(20);
        emailField.setText("mhd_demo@gmailc.com");
        panel.add(emailField, gbc);

        gbc.gridy++;
        panel.add(new JLabel("Enter Password:"), gbc);
        gbc.gridy++;
        passwordField = new JPasswordField(20);
        passwordField.setText("!@#$%^&*");
        panel.add(passwordField, gbc);

        gbc.gridy++;
        JButton loginBtn = createBlueButton("Log in");
        loginBtn.addActionListener(e -> login());
        panel.add(loginBtn, gbc);

        gbc.gridy++;
        JButton registerBtn = createBlueButton("Create Account");
        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterScreen();
        });
        panel.add(registerBtn, gbc);

        gbc.gridy++;
        JButton skipBtn = new JButton("Skip for now");
        skipBtn.addActionListener(e -> {
            dispose();
            new HomeScreen();
        });
        panel.add(skipBtn, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void login() {
        String email = emailField.getText().trim();
        String pass = new String(passwordField.getPassword());

        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Login Successful!");
        dispose();
        new HomeScreen();
    }

    private JButton createBlueButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(0, 122, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return btn;
    }
}