package br.edu.androidasynctask.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.androidasynctask.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoCalcularIMC = (Button) findViewById(R.id.calcularIMCButton);
        Button botaoCalcularVCT = (Button) findViewById(R.id.calcularVCTButton);
        Button botaoCalcularPA = (Button) findViewById(R.id.calcularPAButton);
        
        botaoCalcularIMC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                calcIMC();
            }
        });
    	botaoCalcularVCT.setOnClickListener(new View.OnClickListener(){
    		public void onClick(View v) {
    			calcVCT();
    		}
    	});
	    botaoCalcularPA.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	            calcPerfil();
	        }
	    });

    }
		public void calcIMC (){
		    startActivity(new Intent(this, CalcularIMCActivity.class));
		}
		public void calcVCT (){
		    startActivity(new Intent(this, CalcularVCTAcitivity.class));
		}
		public void calcPerfil(){
		    startActivity(new Intent(this, CalcularPerfilAntropometricoActivity.class));
		}
		

}