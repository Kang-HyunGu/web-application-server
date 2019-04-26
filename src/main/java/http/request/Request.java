package http.request;

import http.message.MessageBody;
import http.message.MessageHeaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Request {

    private RequestLine requestLine;
    private List<MessageHeaders> messageHeaders;
    private MessageBody messageBody;

    public Request(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            throw new RuntimeException();
        }

        requestLine = new RequestLine(bufferedReader.readLine());

//        팩토리 메서드 패턴을 써보자
//        while (bufferedReader.ready()) {
//            messageHeaders.add(bufferedReader.readLine());
//        }
    }

    Request(RequestLine requestLine, List<MessageHeaders> messageHeaders, MessageBody messageBody) {
        this.requestLine = requestLine;
        this.messageHeaders = messageHeaders;
        this.messageBody = messageBody;
    }

    // index.html로 설정 하는건 어느 객체 책임일까
    public String uri() {
        final String uri = requestLine.getRequestUri();

        if ("/".equals(uri)) {
            return "/index.html";
        }

        return uri;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestLine=" + requestLine +
                ", messageHeaders=" + messageHeaders +
                ", messageBody=" + messageBody +
                '}';
    }
}
