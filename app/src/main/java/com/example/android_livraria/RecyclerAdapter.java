package com.example.android_livraria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Livro> listaLivros;
    private View view;
    private ImageView fechar;
    private Context context;

    public RecyclerAdapter(ArrayList<Livro> listaLivros, Context context) {
        this.listaLivros = listaLivros;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Integer foto = listaLivros.get(position).getFoto();
        String titulo = listaLivros.get(position).getTitulo();

        Livro livro = listaLivros.get(position);

        view = holder.getLivroView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, MainActivity02.class);

                Bundle bundle = new Bundle();

                bundle.putInt("foto", livro.getFoto());
                bundle.putString("titulo", livro.getTitulo());
                bundle.putString("autor", livro.getAutor());
                bundle.putString("editora", livro.getEditora());
                bundle.putInt("ano", livro.getAno());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        holder.getFoto().setImageResource(foto);
        holder.getTitulo().setText(titulo);
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }
}
