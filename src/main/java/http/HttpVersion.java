package http;

import java.util.Arrays;

public enum HttpVersion {

    HTTP_1_1("HTTP/1.1");

    private String version;

    HttpVersion(String version) {
        this.version = version;
    }

    public static HttpVersion valueOfVersion(String httpVersion) {
        return Arrays.stream(values())
                .filter(value -> value.version.equals(httpVersion))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
