package bt.gov.dit.officenoticeboard.server.request.util;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Tashi Choden on 19-Jan-17.
 */

public class HttpRequestUtil {
        private static final String REQUEST_GET="GET";
        private static final String REQUEST_POST="POST";
        private static final int INVALID_RESPONSE = -1;

        private URLConnection connection;
        private String urlString;
        private static final String TAG = HttpRequestUtil.class.getSimpleName();

        public HttpRequestUtil(String urlString) {
            this.urlString = urlString;
        }

        public ServerResponse makeHttpGetRequest() throws IOException{
            openConnection(REQUEST_GET);
            ServerResponse serverResponse = getResponse();
            return serverResponse;

        }
        public ServerResponse makeHttpPostRequest(String data) throws IOException{
            openConnection(REQUEST_POST);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(data);
            writer.flush();
            writer.close();
            outputStream.close();

            ServerResponse serverResponse = getResponse();
            return serverResponse;


        }
        private void openConnection( String requestMethod) throws IOException {
            URL url=new URL(urlString);
            connection=url.openConnection();

            if(connection instanceof HttpURLConnection){
                ((HttpURLConnection)connection).setRequestMethod(requestMethod);

            }else if(connection instanceof HttpsURLConnection){
                ((HttpsURLConnection)connection).setRequestMethod(requestMethod);
            }
        }
        private ServerResponse getResponse() {
            int responseCode = INVALID_RESPONSE;
            InputStream inputStream = null;
            try {
                responseCode = getResponseCode();
                inputStream = connection.getInputStream();
            } catch (IOException e) {
                Log.d(TAG, e.getMessage());
            }
            ServerResponse serverResponse = new ServerResponse(responseCode, inputStream);
            return serverResponse;
        }



    private int getResponseCode() throws IOException {
            if(connection instanceof  HttpURLConnection){
                return ((HttpURLConnection) connection).getResponseCode();
            }else {
                return ((HttpsURLConnection) connection).getResponseCode();
            }

    }
}
