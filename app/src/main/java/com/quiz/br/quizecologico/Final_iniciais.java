package com.quiz.br.quizecologico;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Amanda Neves on 19/11/2015.
 */
public class Final_iniciais extends AppCompatActivity {

    TextView txtNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_iniciais);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNota = (TextView) findViewById(R.id.txtNota);
        txtNota.setText("");
    }
}
