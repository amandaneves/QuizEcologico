package com.quiz.br.quizecologico;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Amanda Neves on 28/10/2015.
 */
public class Perguntas_fund_ini extends AppCompatActivity{

    Chronometer tempo;
    ImageButton btnProximo;
    ImageView ivwImagem, ivwNum_pergunta;
    TextView txtPergunta;
    RadioButton rdbResp1, rdbResp2, rdbResp3, rdbResp4;
    ArrayList perguntas = new ArrayList();
    ArrayList alternativas = new ArrayList();
    ArrayList respostas = new ArrayList();
    MenuItem ajuda;

    int r = 0;
    int cont = 1;
    int nota = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas_fund_ini);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivwNum_pergunta = (ImageView) findViewById(R.id.ivwNum_pergunta);
        ivwImagem = (ImageView) findViewById(R.id.ivwImagem);
        btnProximo = (ImageButton) findViewById(R.id.btnProximo_iniciais);
        txtPergunta = (TextView) findViewById(R.id.txtPergunta_iniciais);
        rdbResp1 = (RadioButton) findViewById(R.id.rdbResp1_iniciais);
        rdbResp2 = (RadioButton) findViewById(R.id.rdbResp2_iniciais);
        rdbResp3 = (RadioButton) findViewById(R.id.rdbResp3_iniciais);
        rdbResp4 = (RadioButton) findViewById(R.id.rdbResp4_iniciais);

        perguntas.add("Grande parte do lixo de nossa casa pode ser reciclado. Para contribuir com isso devemos:");
        perguntas.add("Para que serve a lixeira  de cor azul?");
        perguntas.add("Para preservar muitas árvores devemos:");
        perguntas.add("A água é um importante recurso natural que deve ser preservado. Uma das medidas que podemos tomar é:");
        perguntas.add("Como ajudar a preservar as florestas?");

        alternativas.add(".Juntar todos os lixos em um só saco");
        alternativas.add("*Separar os materiais recicláveis do lixo orgânico");
        alternativas.add(".Armazenar somente lixo orgânico");
        alternativas.add(".Queimar tudo");

        alternativas.add(".Jogar comida");
        alternativas.add(".Jogar garrafas de refrigerante");
        alternativas.add(".Jogar brinquedos antigos");
        alternativas.add("*Jogar papel");

        alternativas.add(".Comprar menos jornais");
        alternativas.add(".Reciclar latas de metal");
        alternativas.add("*Reciclar jornais, revistas e papéis");
        alternativas.add(".Desmatar florestas");

        alternativas.add("*Diminuir o tempo no banho");
        alternativas.add(".Lavar calçada todos os dias");
        alternativas.add(".Tomar banhos demorados");
        alternativas.add(".Lavar carro usando a mangueira");

        alternativas.add(".Desmatando");
        alternativas.add("*Preservando como  ela é");
        alternativas.add(".Com queimadas");
        alternativas.add(".Construindo cidade em cima delas");

        ivwNum_pergunta.setImageResource(R.drawable.ic_number_one);

        txtPergunta.setText(perguntas.get(0).toString());
        rdbResp1.setText(alternativas.get(0).toString().substring(1));
        rdbResp2.setText(alternativas.get(1).toString().substring(1));
        rdbResp3.setText(alternativas.get(2).toString().substring(1));
        rdbResp4.setText(alternativas.get(3).toString().substring(1));
        r = 3;
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( rdbResp1.isChecked() || rdbResp2.isChecked() || rdbResp3.isChecked() || rdbResp4.isChecked()) {
                    if(cont != perguntas.size()) {
                        txtPergunta.setText(perguntas.get(cont).toString());
                        rdbResp1.setText(alternativas.get(r+1).toString().substring(1));
                        rdbResp2.setText(alternativas.get(r+2).toString().substring(1));
                        rdbResp3.setText(alternativas.get(r+3).toString().substring(1));
                        rdbResp4.setText(alternativas.get(r+4).toString().substring(1));
                        if(rdbResp1.isChecked()){
                            respostas.add(alternativas.get(r+1).toString().subSequence(0,1));
                        }
                        else if(rdbResp2.isChecked()){
                            respostas.add(alternativas.get(r+1).toString().subSequence(0,1));
                        }
                        else if(rdbResp3.isChecked()){
                            respostas.add(alternativas.get(r+1).toString().subSequence(0,1));
                        }
                        else{
                            respostas.add(alternativas.get(r+1).toString().subSequence(0,1));
                        }
                        r+=4;
                        cont++;
                        rdbResp1.setChecked(false);
                        rdbResp1.setSelected(false);
                        rdbResp2.setChecked(false);
                        rdbResp2.setSelected(false);
                        rdbResp3.setChecked(false);
                        rdbResp3.setSelected(false);
                        rdbResp4.setChecked(false);
                        rdbResp4.setSelected(false);
                    }
                    else{
                        int a = 0;
                        System.out.println(respostas.size());
                        while(a < respostas.size()){
                            System.out.println(respostas.get(a).toString());
                            if(respostas.get(a).toString() == "*"){
                                nota+=2;
                            }
                            a++;
                        }
                        Intent i = new Intent(Perguntas_fund_ini.this, Final_iniciais.class);
                        i.putExtra("Nota",nota);
                        startActivity(i);
                    }
                }
                else{
                    Toast msg = Toast.makeText(getApplicationContext(), "Selecione uma alternativa.", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        ajuda = (MenuItem) menu.findItem(R.id.action_help);
        ajuda.getIcon().setColorFilter(Color.argb(255,255,255,255), PorterDuff.Mode.SRC_ATOP);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
