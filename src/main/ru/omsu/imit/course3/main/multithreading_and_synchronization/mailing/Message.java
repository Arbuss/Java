package ru.omsu.imit.course3.main.multithreading_and_synchronization.mailing;

public class Message {
    private String email;
    private String sender;
    private String subject;
    private String body;

    public Message(String email, String sender, String subject, String body) {
        this.email = email;
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }

    public String getEmail(){
        return email;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
