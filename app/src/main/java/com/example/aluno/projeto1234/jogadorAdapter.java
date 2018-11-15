package com.example.aluno.projeto1234;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class jogadorAdapter extends BaseAdapter
{
    private Context contexto;
    private List<Jogador> listadeJogador;
    private LayoutInflater inflater;

    public jogadorAdapter(Context context, List<Jogador> lista) {
        this.contexto = context;
        this.listadeJogador = lista;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listadeJogador.size();
    }

    @Override
    public Object getItem(int position) {
        return listadeJogador.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listadeJogador.get(position).getId_jogador();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Suporte item;
       if(view == null){
            view = inflater.inflate(R.layout.layout_jogadores, null);
            item = new Suporte();
            item.jogador = (TextView) view.findViewById(R.id.tvJogador);
            item.idade = (TextView) view.findViewById(R.id.tvIdade);
            view.setTag(item);
        }else{
            item = (Suporte) view.getTag();
        }
        Jogador jogador = listadeJogador.get(position);
        item.jogador.setText(jogador.getNome_jogador());
        item.idade.setText(String.valueOf(jogador.getIdade_jogador()));
        return view;
    }
    public class Suporte{
        TextView jogador, idade;
    }


}
