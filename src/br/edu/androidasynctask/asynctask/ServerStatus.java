package br.edu.androidasynctask.asynctask;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.androidasynctask.activity.LoginActivity;
import br.edu.androidasynctask.util.HttpService;
import br.edu.androidasynctask.util.Response;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class ServerStatus extends AsyncTask<JSONObject, Void, Response> {

    private Activity activity;

    public ServerStatus(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected Response doInBackground(JSONObject... params) {

    	HttpURLConnection connection = null;
    	Response response = null;

        try {

            connection = HttpService.sendGetRequest("statusServer");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int httpCode = 0;
        
		try {
			httpCode = connection.getResponseCode();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        String content = HttpService.getHttpContent(connection);
        response = new Response(httpCode, content);

        return response;
    }
    @Override
     protected void onPostExecute(Response response) {

        try {

            int status;
            status = response.getStatusCodeHttp();

            if (status == 201) {

                JSONObject json = new JSONObject(response.getContentValue());

                Boolean statusServer = json.getBoolean("online");

                if(statusServer){
                    Intent intent = new Intent(activity, LoginActivity.class);
                    activity.startActivity(intent);
                }
                
                activity.finish();
            }

        } catch (JSONException e) {

            Log.e("Aplicação android", "JSONException: " + e);
        } 
    }

}
