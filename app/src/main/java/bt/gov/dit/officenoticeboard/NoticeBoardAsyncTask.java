package bt.gov.dit.officenoticeboard;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import bt.gov.dit.officenoticeboard.server.request.util.HttpRequestUtil;
import bt.gov.dit.officenoticeboard.server.request.util.ServerResponse;

/**
 * Created by Jigme on 1/26/2017.
 */

public class NoticeBoardAsyncTask extends AsyncTask<Integer , Void, ArrayList<Notices>> {

    private Context context;
    private OnReceiveNotices onReceiveNotices;

    private ProgressDialog progressDialog;

    public NoticeBoardAsyncTask(Context context, OnReceiveNotices onReceiveNotices){
        this.context = context;
        this.onReceiveNotices = onReceiveNotices;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Getting NoticeBoard");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();
    }

    @Override
    protected ArrayList<Notices> doInBackground(Integer... params) {
        int noticesInt = params[0];
        String urlString = getUrl();

        HttpRequestUtil httpRequestUtil = new HttpRequestUtil(urlString);
        try {
            ServerResponse serverResponse = httpRequestUtil.makeHttpGetRequest();
            InputStream inputStream = serverResponse.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Gson gson = new GsonBuilder().create();
            ArrayList<Notices> notices= gson.fromJson(bufferedReader, new TypeToken<List<Notices>>(){}.getType());
            return notices;
        }catch (IOException e){

        }
        return null;

    }

    @Override
    protected void onPostExecute(ArrayList<Notices> notices) {
        super.onPostExecute(notices);
        progressDialog.dismiss();
        onReceiveNotices.onReceive(notices);
    }

    private String getUrl(){
        return  "http://192.168.3.73/officeNoticeBoard/json/noticedata.php";

    }
}
