package com.example.segundograuequacao;

import static java.lang.Math.*;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valorUm;
    private EditText valorDois;
    private EditText valorTres;
    private Button botaoCalcular;
    private TextView mostrarDelta;
    private TextView mostrarXUm;
    private TextView mostrarXDois;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.body), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        valorUm = findViewById(R.id.valorUm);
        valorDois = findViewById(R.id.valorDois);
        valorTres = findViewById(R.id.valorTres);
        botaoCalcular = findViewById(R.id.botaoCalcular);
        mostrarDelta = findViewById(R.id.mostrarDelta);
        mostrarXUm = findViewById(R.id.mostrarXUm);
        mostrarXDois = findViewById(R.id.mostrarXDois);

        botaoCalcular.setOnClickListener(op -> calcular());
    }

    private void calcular()
    {
        double v1 = Double.parseDouble(valorUm.getText().toString());
        double v2 = Double.parseDouble(valorDois.getText().toString());
        double v3 = Double.parseDouble(valorTres.getText().toString());
        double delta = ((v2*v2) - (4*v1*v3));
        double resultado1 =  (-v2 + sqrt(delta)) / (2*v1);
        double resultado2 =  (-v2 - sqrt(delta)) / (2*v1);
        if(delta <= 0)
        {
            String dt = getString(R.string.delta) + " = " + delta;
            mostrarDelta.setText(dt);
            mostrarXUm.setText("Delta negativo, não existe raíz 1.");
            mostrarXDois.setText("Delta negativo, não existe raíz 2.");
        }
        else
        {

            String dt = getString(R.string.delta) + " = " + delta;
            String rum = getString(R.string.res1) + " = " + resultado1;
            String rdois = getString(R.string.res2) + " = " + resultado2;
            mostrarDelta.setText(dt);
            mostrarXUm.setText(rum);
            mostrarXDois.setText(rdois);
        }

    }


}