// data/ChatDatabase.java
package data;

import model.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatDatabase {
    private static Map<String, List<Message>> chats = new HashMap<>();

    public static List<Message> getChat(String hostelName) {
        return chats.computeIfAbsent(hostelName, k -> new ArrayList<>());
    }

    public static void addMessage(String hostelName, Message msg) {
        getChat(hostelName).add(msg);
    }
}