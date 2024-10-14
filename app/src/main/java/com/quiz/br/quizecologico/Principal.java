package com.quiz.br.quizecologico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText txtNome_usu;
    private ImageButton btnStart, btnInfo;
    private RadioButton rbnProfessor, rbnAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNome_usu = (EditText) findViewById(R.id.txtNome_usu);
        btnInfo = (ImageButton) findViewById(R.id.btnInfo);
        btnStart = (ImageButton) findViewById(R.id.btnStart);
        rbnAluno = (RadioButton) findViewById(R.id.rbnAluno);
        rbnProfessor = (RadioButton) findViewById(R.id.rbnProfessor);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNome_usu.getText().length() <= 0){
                    Toast msg = Toast.makeText(getApplicationContext(), "Informe seu nome para continuar.", Toast.LENGTH_SHORT);
                    msg.show();
                }
                else if(!rbnAluno.isChecked() && !rbnProfessor.isChecked()){
                    Toast msg = Toast.makeText(getApplicationContext(), "Informe se é Aluno ou Professor.", Toast.LENGTH_SHORT);
                    msg.show();
                }
                else if(rbnProfessor.isChecked()){
                    Toast msg = Toast.makeText(getApplicationContext(), "Rotina para Professor em desenvolvimento.", Toast.LENGTH_SHORT);
                    msg.show();
                }
                else {
                    Intent i = new Intent(Principal.this, Nivel.class);
                    startActivity(i);
                }
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this, Info.class);
                startActivity(i);
            }
        });
    }
}
