// model/Message.java
package model;

public class Message {
    private String text;
    private boolean isUser; // true = user, false = manager

    public Message(String text, boolean isUser) {
        this.text = text;
        this.isUser = isUser;
    }

    public String getText() { return text; }
    public boolean isUser() { return isUser; }
}