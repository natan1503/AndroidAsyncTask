<<<<<<< HEAD
package br.edu.androidasynctask.asynctask;

import java.io.IOException;


import org.json.JSONObject;

import br.edu.androidasynctask.activity.MainActivity;
import br.edu.androidasynctask.util.HttpService;
import br.edu.androidasynctask.util.Response;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class VerificaLoginAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    private Activity activity;

    public VerificaLoginAsyncTask(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected Response doInBackground(JSONObject... valores) {

        Response response = null;

        try {

            response = HttpService.sendJSONPostResquest("verificarLogin",valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
    
    @Override
    protected void onPostExecute(Response response) {

        int statusHTTP;
		statusHTTP = response.getStatusCodeHttp();

		if (statusHTTP == 202) {
		    Intent intent = new Intent(activity, MainActivity.class);
		    activity.startActivity(intent);

		}else{
		    Toast.makeText(activity,"Senha incorreta", Toast.LENGTH_LONG).show();
		}
		
		activity.finish();
    }

}
=======
package br.edu.androidasynctask.asynctask;

import java.io.IOException;


import org.json.JSONObject;

import br.edu.androidasynctask.activity.MainActivity;
import br.edu.androidasynctask.util.HttpService;
import br.edu.androidasynctask.util.Response;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class VerificaLoginAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    private Activity activity;

    public VerificaLoginAsyncTask(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected Response doInBackground(JSONObject... valores) {

        Response response = null;

        try {

            response = HttpService.sendJSONPostResquest("verificarLogin",valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
    
    @Override
    protected void onPostExecute(Response response) {

        int statusHTTP;
		statusHTTP = response.getStatusCodeHttp();

		if (statusHTTP == 202) {
		    Intent intent = new Intent(activity, MainActivity.class);
		    activity.startActivity(intent);

		}else{
		    Toast.makeText(activity,"Senha incorreta", Toast.LENGTH_LONG).show();
		}
		
		activity.finish();
    }

}
>>>>>>> origin/master
