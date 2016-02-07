package br.edu.androidasynctask.listener;



import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.androidasynctask.R;
import br.edu.androidasynctask.asynctask.CalcularVCTAsyncTask;

public class CalcularVCTListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        RadioGroup radioNivelEsporte = (RadioGroup) v.findViewById(R.id.NivelEsporte);

        // Calcular o VCT
        
        Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

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

            //Nível Esporte
            int selectedId = radioNivelEsporte.getCheckedRadioButtonId();
            radioNivelEsporte = (RadioGroup) v.findViewById(selectedId);
            String nivelEsporte = radioNivelEsporte.toString();

            geral.put("nivelEsporte", nivelEsporte);

            //Entrevistado
            JSONObject entrevistado = new JSONObject();

            //Sexo do Entrevistado
            EditText sexoEditText = (EditText) v.findViewById(R.id.sexoEditText);
            String sexo = sexoEditText.getText().toString();
            geral.put("sexo", sexo);

            //Data de Nascimento
            EditText dataNascimentoEditText = (EditText) v.findViewById(R.id.dataNascimentoEditText);
            String dataNascimento = dataNascimentoEditText.getText().toString();
            entrevistado.put("dataNascimento", dataNascimento);

            geral.put("entrevistado", entrevistado);
            //Enviar os dados de geral para o AsyncTask

            CalcularVCTAsyncTask calcularVCTAsyncTask = new CalcularVCTAsyncTask(v.getContext());
            calcularVCTAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
