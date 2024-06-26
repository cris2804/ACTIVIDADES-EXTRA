package org.example;

import java.util.ArrayList;
import java.util.List;

public class MockMailServer implements MailServer {
    //clase para capturar los parametros de sendEmail
    public static class Email{
        public String email;
        public String message;
        public Email(String email, String message){
            this.email = email;
            this.message = message;
        }
    }
    //lista para almenecar las llamdas a senEmail
    private List<Email> emails = new ArrayList<Email>();
    @Override
    public void sendEmail(String email, String message) {
        emails.add(new Email(email, message));
    }

    public List<Email> getSentEmails() {
        return emails;
    }
    public void clearSentEmails(){
        emails.clear();
    }


}

