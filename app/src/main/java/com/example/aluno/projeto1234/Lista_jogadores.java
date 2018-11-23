package com.example.aluno.projeto1234;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class Lista_jogadores extends AppCompatActivity {


    private ListView lvPlayers;
    private List<Jogador> jogadores;
    private Jogador_adapter adapter;

    private FirebaseDatabase database;
    private DatabaseReference reference;
    private Query queryRef;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogadores);
        System.out.println("onCreate");

        jogadores = new ArrayList<>();
        lvPlayers = (ListView) findViewById(R.id.lvJogadores);

        adapter = new Jogador_adapter(Lista_jogadores.this, jogadores);
        lvPlayers.setAdapter(adapter);

       // adapter = new ArrayAdapter(this,
         //       android.R.layout.simple_list_item_1, jogadores);
        //lvPlayers.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        queryRef = reference.child("jogadores").orderByChild("nome");

        jogadores.clear();

        System.out.println("onStart");

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                Jogador j = new Jogador();
                j.setId_jogador(dataSnapshot.getKey());
                j.setNome_jogador(dataSnapshot.child("nome_jogador").getValue(String.class));
                j.setIdade_jogador(dataSnapshot.child("idade_jogador").getValue(Integer.class));
                jogadores.add(j);
                adapter.notifyDataSetChanged();
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
        queryRef.addChildEventListener(childEventListener);
    }


    @Override
    protected void onStop() {
        super.onStop();
        queryRef.removeEventListener(childEventListener);
    }
}
