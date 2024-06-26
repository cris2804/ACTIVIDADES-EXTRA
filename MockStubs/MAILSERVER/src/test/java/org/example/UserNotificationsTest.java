package org.example;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class UserNotificationsTest {
    private MockMailServer mockMailServer;
    private UserNotifications userNotifications;
    @BeforeEach
    void setUp() {
        mockMailServer = new MockMailServer();
        userNotifications = new UserNotifications(mockMailServer);
    }
    @Test
    public void testSendEmail() {
        String email = "test@example.com";
        String message = "Hello, this is a test email!";

        userNotifications.sendEmail(email, message);

        List<MockMailServer.Email> sentEmails = mockMailServer.getSentEmails();

        assertEquals(1, sentEmails.size());
        assertEquals(email, sentEmails.get(0).email);
        assertEquals(message, sentEmails.get(0).message);
    }

    @Test
    public void testSendMultipleEmails() {
        String email1 = "user1@example.com";
        String message1 = "Message for user1";
        String email2 = "user2@example.com";
        String message2 = "Message for user2";

        userNotifications.sendEmail(email1, message1);
        userNotifications.sendEmail(email2, message2);

        List<MockMailServer.Email> sentEmails = mockMailServer.getSentEmails();

        assertEquals(2, sentEmails.size());
        assertEquals(email1, sentEmails.get(0).email);
        assertEquals(message1, sentEmails.get(0).message);
        assertEquals(email2, sentEmails.get(1).email);
        assertEquals(message2, sentEmails.get(1).message);
    }

    @Test
    public void testSendEmailWithoutMessage() {
        String email = "test@example.com";
        String message = "";

        userNotifications.sendEmail(email, message);

        List<MockMailServer.Email> sentEmails = mockMailServer.getSentEmails();

        assertEquals(1, sentEmails.size());
        assertEquals(email, sentEmails.get(0).email);
        assertEquals(message, sentEmails.get(0).message);
    }

    @Test
    public void testSendEmailWithNullMessage() {
        String email = "test@example.com";
        String message = null;

        userNotifications.sendEmail(email, message);

        List<MockMailServer.Email> sentEmails = mockMailServer.getSentEmails();

        assertEquals(1, sentEmails.size());
        assertEquals(email, sentEmails.get(0).email);
        assertNull(sentEmails.get(0).message);
    }

    @Test
    public void testClearSentEmails() {
        String email = "test@example.com";
        String message = "Hello, this is a test email!";

        userNotifications.sendEmail(email, message);

        mockMailServer.clearSentEmails();

        List<MockMailServer.Email> sentEmails = mockMailServer.getSentEmails();

        assertEquals(0, sentEmails.size());
    }
}