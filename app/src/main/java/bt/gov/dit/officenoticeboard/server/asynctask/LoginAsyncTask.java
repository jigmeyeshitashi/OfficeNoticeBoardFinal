package bt.gov.dit.officenoticeboard.server.asynctask;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import bt.gov.dit.officenoticeboard.callback.OnReceiveResult;
import bt.gov.dit.officenoticeboard.server.request.util.HttpRequestUrls;
import bt.gov.dit.officenoticeboard.server.request.util.HttpRequestUtil;
import bt.gov.dit.officenoticeboard.server.request.util.ServerResponse;
import bt.gov.dit.officenoticeboard.server.response.model.LoginResponse;

/**
 * Created by Tashi Choden on 25-Jan-17.
 */

public class LoginAsyncTask extends AsyncTask<String, Void, LoginResponse>{

    OnReceiveResult onReceiveResult;

    public LoginAsyncTask(OnReceiveResult onReceiveResult) {
        this.onReceiveResult = onReceiveResult;
    }

    @Override
    protected LoginResponse doInBackground(String... params) {
        String loginUrl = String.format(HttpRequestUrls.LOGIN_URL, params[0], params[1]);
        HttpRequestUtil requestUtil = new HttpRequestUtil(loginUrl);
        try {
            ServerResponse serverResponse = requestUtil.makeHttpGetRequest();
            InputStream inputStream = serverResponse.getInputStream();
            InputStreamReader inputStream1=new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStream1);
            Gson gson = new GsonBuilder().create();
            LoginResponse response = gson.fromJson(bufferedReader, LoginResponse.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(LoginResponse response) {
        super.onPostExecute(response);
        if(onReceiveResult != null){
            onReceiveResult.onReceive(response);
        }
    }
}
