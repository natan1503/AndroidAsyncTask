package br.edu.androidasynctask.activity;


import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import br.edu.androidasynctask.R;
import br.edu.androidasynctask.asynctask.CalcularVCTAsyncTask;

public class CalcularVCTAcitivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcularvct);

        Button calcularVCTButton = (Button) findViewById(R.id.calcularVCTButton);
        calcularVCTButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        RadioGroup radioNivelEsporte = (RadioGroup) findViewById(R.id.radioNivelEsporte);

        // Calcular o VCT
        
        Log.i("NotificationWearApp", "Clique no bot�o da AsyncTask");

        JSONObject geral = new JSONObject();

        try {
            // Peso
            EditText pesoEditText = (EditText) v.findViewById(R.id.pesoEditText);
            String peso = pesoEditText.getText().toString();
            geral.put("peso", peso);

            // Altura
            EditText alturaEditText = (EditText) v.findViewById(R.id.alturaEditText);
            String altura = alturaEditText.getText().toString();
            geral.put("altura", altura);

            //N�vel Esporte
            int selectedId = radioNivelEsporte.getCheckedRadioButtonId();
            radioNivelEsporte = (RadioGroup) findViewById(selectedId);
            String nivelEsporte = radioNivelEsporte.toString();

            geral.put("nivelEsporte", nivelEsporte);

            //Entrevistado
            JSONObject entrevistado = new JSONObject();

            //Sexo do Entrevistado
            EditText sexoEditText = (EditText) v.findViewById(R.id.sexoEditText);
            String sexo = pesoEditText.getText().toString();
            geral.put("sexo", sexo);

            //Data de Nascimento
            EditText dataNascimentoEditText = (EditText) v.findViewById(R.id.dataNascimentoEditText);
            String dataNascimento = dataNascimentoEditText.getText().toString();
            entrevistado.put("dataNascimento", dataNascimento);

            geral.put("entrevistado", entrevistado);
            //Enviar os dados de geral para o AsyncTask

            CalcularVCTAsyncTask calcularVCTAsyncTask = new CalcularVCTAsyncTask(this);
            calcularVCTAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

