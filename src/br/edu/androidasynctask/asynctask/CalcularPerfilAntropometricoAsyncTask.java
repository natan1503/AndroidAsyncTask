package br.edu.androidasynctask.asynctask;

	import android.content.Context;
	import android.os.AsyncTask;
	import android.util.Log;
	import android.widget.Toast;

	import org.json.JSONException;
	import org.json.JSONObject;

	import java.io.IOException;


	import br.edu.androidasynctask.util.HttpService;
	import br.edu.androidasynctask.util.Response;

	/**
	 * Created by NATAN on 03/02/2016.
	 */
	public class CalcularPerfilAntropometricoAsyncTask extends AsyncTask<JSONObject, Void, Response> {

	    Context context;

	    public CalcularPerfilAntropometricoAsyncTask(Context context){
	        this.context = context;
	    }

	    protected Response doInBackground(JSONObject... valores) {

	        Response response = null;

	        try {

	            response = HttpService.sendJSONPostResquest("calcularVCT", valores[0]);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return response;
	    }
	    @Override
	    protected void onPostExecute(Response response) {

	        try {

	            int status = response.getStatusCodeHttp();

	            if (status == 202) {

	                JSONObject json = new JSONObject(response.getContentValue());

	                String valor = json.getString("valor");
	                Log.i("NotificationWearApp", "Nome: " + valor);
	                Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
	            }

	        } catch (JSONException e) {

	            Log.e("NotificationWearApp", "JSONException: " + e);
	        }
	    }

	}
