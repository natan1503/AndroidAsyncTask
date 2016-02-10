package br.edu.androidasynctask.activity;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.androidasynctask.R;
import br.edu.androidasynctask.asynctask.VerificaLoginAsyncTask;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button enviar = (Button) findViewById(R.id.enviarLogin);

        enviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JSONObject geral = new JSONObject();

                        try {

                            EditText loginEditText = (EditText) findViewById(R.id.edit_Text_Login);
                            String login = loginEditText.getText().toString();
                            geral.put("login", login);


                            EditText senhaEditText = (EditText) findViewById(R.id.edit_Text_Senha);
                            String senha = senhaEditText.getText().toString();
                            geral.put("senha", senha);


                            VerificaLoginAsyncTask loginAsyncTask = new VerificaLoginAsyncTask(LoginActivity.this);
                            loginAsyncTask.execute(geral);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

}
