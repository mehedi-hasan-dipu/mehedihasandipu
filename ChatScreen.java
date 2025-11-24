// ChatScreen.java
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;
import model.Message;
import data.ChatDatabase;

public class ChatScreen extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private String hostelName;
    private String[] managerReplies = {
        "Hello! How can I help you today?",
        "Yes, rooms are available right now.",
        "You can visit anytime between 9 AM to 8 PM.",
        "Booking can be done online or by visiting.",
        "We provide full meals 3 times a day.",
        "WiFi is high-speed and 24/7.",
        "Yes, laundry service is included.",
        "Security with CCTV and guard 24/7."
    };
    private Random random = new Random();

    public ChatScreen(String hostelName) {
        this.hostelName = hostelName;
        setTitle("Chat with " + hostelName + " Manager");
        setSize(500, 600);
        setLocationRelativeTo(null);

        // Top bar
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(new Color(0, 122, 255));
        top.setPreferredSize(new Dimension(0, 60));
        JLabel title = new JLabel(hostelName + " - Manager Chat");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        top.add(title, BorderLayout.WEST);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(new Color(240, 248, 255));

        // Input
        JPanel bottom = new JPanel(new BorderLayout());
        inputField = new JTextField();
        JButton sendBtn = new JButton("Send");
        sendBtn.setBackground(new Color(0, 122, 255));
        sendBtn.setForeground(Color.WHITE);
        sendBtn.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());
        bottom.add(inputField, BorderLayout.CENTER);
        bottom.add(sendBtn, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        loadPreviousMessages();
        setVisible(true);
    }

    private void sendMessage() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        appendMessage(text, true);
        ChatDatabase.addMessage(hostelName, new Message(text, true));
        inputField.setText("");

        // Auto reply after delay
        new Thread(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
                String reply = managerReplies[random.nextInt(managerReplies.length)];
                SwingUtilities.invokeLater(() -> {
                    appendMessage(reply, false);
                    ChatDatabase.addMessage(hostelName, new Message(reply, false));
                });
            } catch (InterruptedException ignored) {}
        }).start();
    }

    private void appendMessage(String text, boolean isUser) {
        String align = isUser ? "right" : "left";
        String color = isUser ? "#DCF8C6" : "#FFFFFF";
        chatArea.append(
            "<html><div style='margin:10px; padding:10px; background:" + color +
            "; border-radius:15px; max-width:70%; float:" + align + ";'>" +
            text + "</div></html>\n"
        );
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    private void loadPreviousMessages() {
        List<Message> messages = ChatDatabase.getChat(hostelName);
        for (Message m : messages) {
            appendMessage(m.getText(), m.isUser());
        }
    }
}