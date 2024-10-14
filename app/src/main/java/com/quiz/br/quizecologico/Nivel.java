package com.quiz.br.quizecologico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Amanda Neves on 18/10/2015.
 */
public class Nivel extends AppCompatActivity {

    private ImageButton btnIniciais_fund, btnFinais_fund, btnMedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnIniciais_fund = (ImageButton) findViewById(R.id.btnIniciais_fund);
        btnFinais_fund = (ImageButton) findViewById(R.id.btnFinais_fund);
        btnMedio = (ImageButton) findViewById(R.id.btnMedio);

        btnIniciais_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Nivel.this, Perguntas_fund_ini.class);
                startActivity(i);
            }
        });

        btnFinais_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Nivel.this, Perguntas_fund_fin.class);
                startActivity(i);
            }
        });

        btnMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Nivel.this, Perguntas_medio.class);
                startActivity(i);
            }
        });

    }
}
