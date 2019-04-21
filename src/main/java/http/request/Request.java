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

    @Override
    public String toString() {
        return "Request{" +
                "requestLine=" + requestLine +
                ", messageHeaders=" + messageHeaders +
                ", messageBody=" + messageBody +
                '}';
    }
}
