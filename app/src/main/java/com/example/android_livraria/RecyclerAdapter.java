package com.example.android_livraria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Livro> listaLivros;

    public RecyclerAdapter(ArrayList<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String titulo = listaLivros.get(position).getTitulo();
        String autor = listaLivros.get(position).getAutor();

        holder.getTitulo().setText(titulo);
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }
}
