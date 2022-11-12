package com.example.android_livraria;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView titulo;

    public MyViewHolder(final View view){
        super(view);
        titulo = view.findViewById(R.id.titulo);
    }

    public TextView getTitulo() {
        return titulo;
    }
}
