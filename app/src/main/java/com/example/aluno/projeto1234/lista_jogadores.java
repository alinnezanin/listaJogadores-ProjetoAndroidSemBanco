





package com.example.aluno.projeto1234;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class lista_jogadores extends AppCompatActivity {

    private ListView lv;
    private jogadorAdapter adapter;
    private ArrayList<Jogador> listaJogador = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    private ChildEventListener childEventListener;
    private Query queryRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new jogadorAdapter(lista_jogadores.this, listaJogador);
        lv.setAdapter(adapter);

    }

    protected void onStart() {
        super.onStart();

        queryRef = ref.child("jogadores");
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataSnapshot jogadores = dataSnapshot.child("jogadores");
                Jogador jogador = new Jogador();
                jogador.setNome_jogador(dataSnapshot.child("nome_jogador").getValue(String.class));
                jogador.setIdade_jogador(dataSnapshot.child("idade_jogador").getValue(String.class));
                listaJogador.add(jogador);
                System.out.println("jogador "+jogador.getNome_jogador());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };


    }


}