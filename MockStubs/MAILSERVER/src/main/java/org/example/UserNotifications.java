package org.example;

public class UserNotifications implements MailServer {
    private final MailServer mailServer;

    public UserNotifications(MailServer mailServer) {
        this.mailServer = mailServer;
    }


    @Override
    public void sendEmail(String email, String message) {
        mailServer.sendEmail(email, message);
    }
}
