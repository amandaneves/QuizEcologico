package com.quiz.br.quizecologico;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Amanda Neves on 18/10/2015.
 */
public class Info extends AppCompatActivity {

    private ImageButton btnSugestoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSugestoes = (ImageButton) findViewById(R.id.btnSugestoes);
        btnSugestoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mandarEmail = new Intent(Intent.ACTION_SENDTO);
                mandarEmail.setType("text/plain");
                mandarEmail.putExtra(Intent.EXTRA_SUBJECT, "Críticas/Sugestões Quiz Ecológico");
                mandarEmail.putExtra(Intent.EXTRA_TEXT, "Escreva aqui..");
                mandarEmail.setData(Uri.parse("mailto:amandaneves.carmo@gmail.com"));
                mandarEmail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(mandarEmail, "Enviar sugestão com"));
            }
        });
    }
}
