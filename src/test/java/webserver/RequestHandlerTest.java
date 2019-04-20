package webserver;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestHandlerTest {

    private Socket socket;

    @Before
    public void setUp() throws Exception {
        socket = mock(Socket.class);
        when(socket.getInetAddress()).thenReturn(InetAddress.getLocalHost());
    }

    @Test
    public void http_method_get() throws IOException {
        // given
        final String httpHeader = String.join("\n",
                "GET / HTTP/1.1",
                "Host: localhost:8080",
                "User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0",
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                "Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3",
                "Accept-Encoding: gzip, deflate",
                "DNT: 1",
                "Connection: keep-alive",
                "Upgrade-Insecure-Requests: 1",
                "Cache-Control: max-age=0",
                "\n");

        // when
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream(httpHeader.getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

        RequestHandler requestHandler = new RequestHandler(socket);
        requestHandler.run();

        // then

    }

    @Test
    public void connect_index() throws IOException {
        // given
        final String httpHeader = String.join("\n",
                "GET /index.html HTTP/1.1",
                "Host: localhost:8080",
                "User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0",
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                "Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3",
                "Accept-Encoding: gzip, deflate",
                "DNT: 1",
                "Connection: keep-alive",
                "Upgrade-Insecure-Requests: 1",
                "Cache-Control: max-age=0",
                "\n");

        // when
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream(httpHeader.getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

        RequestHandler requestHandler = new RequestHandler(socket);
        requestHandler.run();

        // then

    }
}