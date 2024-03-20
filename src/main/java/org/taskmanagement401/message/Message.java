package org.taskmanagement401.message;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private int id;
    private User sender;
    private User receiver;
    private String contents;
    private LocalDateTime sendTime;

    public Message(int id, User sender, User receiver, String contents, LocalDateTime sendTime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.contents = contents;
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && Objects.equals(sender, message.sender) && Objects.equals(receiver, message.receiver) && Objects.equals(contents, message.contents) && Objects.equals(sendTime, message.sendTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, receiver, contents, sendTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", contents='" + contents + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
