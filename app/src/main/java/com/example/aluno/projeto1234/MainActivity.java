package com.example.aluno.projeto1234;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome, edtIdade;
    private Button btnSalvar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    private ChildEventListener childEventListener;
    private Query queryRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtIdade =  (EditText) findViewById(R.id.edtIdade);
        edtNome = (EditText) findViewById(R.id.edtNome);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Jogador jogador = new Jogador();
                jogador.setIdade_jogador(edtIdade.getText().toString());
                jogador.setNome_jogador(edtNome.getText().toString());

                //linha que salva no banco
                ref.child("jogadores").push().setValue(jogador);
                Toast.makeText(MainActivity.this, "Jogador Salvo com Sucesso", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, lista_jogadores.class);
                startActivity(intent);


            }
        });





    }
}
