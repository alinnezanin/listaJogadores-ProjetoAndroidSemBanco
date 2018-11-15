package com.example.aluno.projeto1234;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class jogadorAdapter_ extends BaseAdapter {

    private Context contexto;
    private List<Jogador> listadeJogador;
    private LayoutInflater inflater;

    public jogadorAdapter_(Context contexto, List<Jogador> listadeJogador) {
        this.contexto = contexto;
        this.listadeJogador = listadeJogador;
        this.inflater = LayoutInflater.from(contexto);
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
