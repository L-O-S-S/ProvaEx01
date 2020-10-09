package com.example.exercicio01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNum;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum = findViewById(R.id.edtNum);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numVerification =edtNum.getText().toString();
                boolean calc = true;
                String bin = "";
                int numero = 0;
                if(TextUtils.isEmpty(numVerification))
                {
                    calc = false;
                    edtNum.setError("Este campo é obrigatório");
                } else
                {

                    numero = Integer.parseInt(edtNum.getText().toString());
                    if(numero%2 == 0)
                    {
                        bin = "Par";
                    }
                    else
                    {
                        bin = "Impar";
                    }
                }

                if(calc)
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Resultados");
                    dialog.setMessage("O número é: " + bin + "\n" +
                            numero + " X 2 = " + (numero*2) + "\n" +
                            "Raiz Quadrada = " + (double)Math.sqrt(numero));
                    dialog.setNeutralButton("Fechar", null);
                    dialog.show();
                }

            }
        });
    }
}