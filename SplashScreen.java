// SplashScreen.java
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    private JProgressBar progressBar;

    public SplashScreen() {
        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("StayMate", SwingConstants.CENTER);
        title.setFont(new Font("Inter", Font.BOLD, 64));
        title.setForeground(new Color(0, 122, 255));

        JLabel subtitle = new JLabel("Find your perfect stay", SwingConstants.CENTER);
        subtitle.setFont(new Font("Inter", Font.PLAIN, 22));
        subtitle.setForeground(Color.GRAY);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0, 122, 255));
        progressBar.setPreferredSize(new Dimension(400, 24));

        panel.add(title, BorderLayout.NORTH);
        panel.add(subtitle, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        // Simulate loading
        new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i += 2) {
                    final int progress = i;
                    SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                    Thread.sleep(60);
                }
                dispose();
                new LoginScreen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}