package com.example.abhilashayadav.firebasebasics.Model;

/**
 * Created by Abhilasha Yadav on 12/27/2017.
 */

public class ChatMessage {
    private String messageText;
    private String messageUser;

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    private String messageTime;

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    private String deviceToken;

    public ChatMessage() {

    }

    public ChatMessage(String s, String displayName, String l, String deviceToken) {
        this.messageText = s;
        this.messageUser = displayName;
        this.deviceToken = deviceToken;
        this.messageTime = l;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }


}
