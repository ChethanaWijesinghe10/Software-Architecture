package StructuralDesignPattern;

 interface MessageService {

    void sendMessage(String message, String recipient);
}


 class NotificationSystem {

    private MessageService messageService;

    public NotificationSystem(MessageService messageService) {

                this.messageService = messageService;
    }

    public void notify(String message, String recipient) {

                messageService.sendMessage(message, recipient);
    }
}
class EmailAdapter implements MessageService {

    private EmailService emailService = new EmailService();
    @Override
    public void sendMessage(String message, String recipient) {

        emailService.sendEmail(recipient, message);
    }
}




public class AdapterDesignPattern {
    public static void main(String[] args) {
        MessageService emailAdapter = new EmailAdapter();
        NotificationSystem notificationSystem = new NotificationSystem(emailAdapter);
        notificationSystem.notify("Hello, this is a test message.",
                "test@example.com");
    }
}

 class EmailService {
    public void sendEmail(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }}
