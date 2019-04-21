package http.message;

public class MessageBody implements MessageHeaders {

    private String messageBody;

    public MessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
