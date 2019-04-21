package http.request;

import http.HttpVersion;
import http.Method;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    public void request_line_separated_by_SP_characters() {
        // given
        // when
        RequestLine rootRequestLine = new RequestLine("GET / HTTP/1.1");
        RequestLine indexRequestLine = new RequestLine("GET /index.html HTTP/1.1");

        // then
        assertThat(rootRequestLine.getMethod()).isEqualTo(Method.GET);
        assertThat(rootRequestLine.getRequestUri()).isEqualTo("/");
        assertThat(rootRequestLine.getHttpVersion()).isEqualTo(HttpVersion.HTTP_1_1);

        assertThat(indexRequestLine.getMethod()).isEqualTo(Method.GET);
        assertThat(indexRequestLine.getRequestUri()).isEqualTo("/index.html");
        assertThat(indexRequestLine.getHttpVersion()).isEqualTo(HttpVersion.HTTP_1_1);
    }
}