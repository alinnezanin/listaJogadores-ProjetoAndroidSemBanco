package com.example.aluno.projeto1234;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Jogador_adapter extends BaseAdapter {

    private Context contexto;
    private List<Jogador> listaDeJogadores;
    private LayoutInflater inflater;

    public Jogador_adapter(Context context, List<Jogador> lista) {
        this.contexto = context;
        this.listaDeJogadores = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaDeJogadores.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDeJogadores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Suporte item;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.jogagor_layout, null);
            item = new Suporte();
            item.nome = (TextView) convertView.findViewById(R.id.layout_jog_tvNome);
            item.idade = (TextView) convertView.findViewById(R.id.layout_jog_tvIdade);

            convertView.setTag(item);
        }else{
            item = (Suporte) convertView.getTag();
        }
        Jogador jog = listaDeJogadores.get(position);
        item.nome.setText(jog.getNome_jogador());
        item.idade.setText(String.valueOf(jog.getIdade_jogador()));


        return convertView;
    }


    public class Suporte{
        TextView nome, idade;
        View linha;
    }














}
