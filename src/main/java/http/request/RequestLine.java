package http.request;

import http.HttpVersion;
import http.Method;
import http.message.Message;
import org.apache.commons.lang3.StringUtils;

/**
 * https://tools.ietf.org/html/rfc2616#section-5.1
 *
 * The Request-Line begins with a method token, followed by the
 * Request-URI and the protocol version, and ending with CRLF. The
 * elements are separated by SP characters. No CR or LF is allowed
 * except in the final CRLF sequence.
 *
 * Request-Line = Method SP Request-URI SP HTTP-Version CRLF
 */
public class RequestLine implements Message {

    private final Method method;
    private final String requestUri;
    private final HttpVersion httpVersion;

    public RequestLine(final String requestLine) {
        if (StringUtils.isBlank(requestLine)) {
            throw new IllegalArgumentException();
        }

        final String SP = " ";
        final String[] splitRequestLine = StringUtils.split(requestLine, SP);

        final int METHOD_INDEX = 0;
        final int REQUEST_URI_INDEX = 1;
        final int HTTP_VERSION_INDEX = 2;

        method = Method.valueOf(splitRequestLine[METHOD_INDEX]);
        requestUri = splitRequestLine[REQUEST_URI_INDEX];
        httpVersion = HttpVersion.valueOfVersion(splitRequestLine[HTTP_VERSION_INDEX]);
    }

    public Method getMethod() {
        return method;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String toString() {
        return "RequestLine{" +
                "method=" + method +
                ", requestUri='" + requestUri + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                '}';
    }
}
