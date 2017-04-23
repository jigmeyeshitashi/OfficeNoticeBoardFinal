package bt.gov.dit.officenoticeboard.server.request.util;

import java.io.InputStream;

/**
 * Created by Tashi Choden on 19-Jan-17.
 */
public class ServerResponse {
    private int responseCode;
    private InputStream inputStream;


    public ServerResponse(int responseCode, InputStream inputStream) {
        this.responseCode = responseCode;
        this.inputStream = inputStream;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}