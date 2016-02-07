package br.edu.androidasynctask.listener;

import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.androidasynctask.R;
import br.edu.androidasynctask.asynctask.CalcularPerfilAntropometricoAsyncTask;

public class CalcularPerfilAntropometricoListener implements View.OnClickListener {
	@Override
    public void onClick(View v) {

    	
        JSONObject geral = new JSONObject();

        try {
            // Peso
            EditText pesoEditText = (EditText) v.findViewById(R.id.pesoEditTextPA);
            String peso = pesoEditText.getText().toString();
            geral.put("peso", peso);

            // Altura
            EditText alturaEditText = (EditText) v.findViewById(R.id.alturaEditTextPA);
            String altura = alturaEditText.getText().toString();
            geral.put("altura", altura);

            //Entrevistado
            JSONObject entrevistado = new JSONObject();

            //Sexo do Entrevistado
            
            EditText sexoEditText = (EditText) v.findViewById(R.id.sexoEditText);
            String sexo = sexoEditText.getText().toString();
            geral.put("sexo", sexo);

            //Data de Nascimento
            EditText dataNascimentoEditTextPerfilAntropometrico = (EditText) v.findViewById(R.id.dataNascimentoEditTextPA);
            String dataNascimento = dataNascimentoEditTextPerfilAntropometrico.getText().toString();
            entrevistado.put("dataNascimento", dataNascimento);

            geral.put("entrevistado", entrevistado);
            //Enviar os dados de geral para o AsyncTask

            CalcularPerfilAntropometricoAsyncTask calcularPerfilAntropometricoAsyncTask = new CalcularPerfilAntropometricoAsyncTask(v.getContext());
            calcularPerfilAntropometricoAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}
