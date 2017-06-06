package com.kaist.antr.firebasechatapp2.messages;

import java.util.Date;

public class ChatMessage {

    private String messageText;
    private String messageUser;
    private String messageEmail;
    private long messageTime;
    private double messageLongitude;



    private double messageLatitude;

    public ChatMessage(String messageText, String messageUser, String messageEmail, double messageLongitude, double messageLatitude) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messageEmail = messageEmail;
        this.messageLongitude = messageLongitude;
        this.messageLatitude = messageLatitude;

        // Initialize to current time
        messageTime = new Date().getTime();
    }

    public ChatMessage(){

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

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    public double getMessageLongitude() {
        return messageLongitude;
    }

    public void setMessageLongitude(double messageLongitude) {
        this.messageLongitude = messageLongitude;
    }

    public double getMessageLatitude() {
        return messageLatitude;
    }

    public void setMessageLatitude(double messageLatitude) {
        this.messageLatitude = messageLatitude;
    }
    public String getMessageEmail() {
        return messageEmail;
    }

    public void setMessageEmail(String messageEmail) {
        this.messageEmail = messageEmail;
    }
}
