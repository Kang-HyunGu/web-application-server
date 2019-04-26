package http.request;

import http.HttpVersion;
import http.Method;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    public void request_line은_공백으로_분리된다() {
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

    @Test
    public void uri가_슬래시면_index_html로_반환한다() {
        // given
        RequestLine rootRequestLine = new RequestLine("GET / HTTP/1.1");
        Request request = new Request(rootRequestLine, null, null);

        // when
        String uri = request.uri();

        // then
        assertThat(uri).isEqualTo("/index.html");
    }
}