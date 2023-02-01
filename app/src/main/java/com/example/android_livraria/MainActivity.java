package com.example.android_livraria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    private static ArrayList<Livro> listaLivros = new ArrayList<>();
//    private RecyclerAdapter adapter;

    static {
        listaLivros.add(new Livro(R.drawable.asmilpartesdomeucoracao, "As mil partes do meu coração", "Colleen Hoover", "Galera", 2017));
        listaLivros.add(new Livro(R.drawable.eassimqueacaba, "É assim que acaba", "Colleen Hoover", "Galera", 2018));
        listaLivros.add(new Livro(R.drawable.eassimquecomeca, "É assim que começa", "Colleen Hoover", "Galera", 2022));
        listaLivros.add(new Livro(R.drawable.novembro9, "Novembro, 9", "Colleen Hoover", "Galera", 2015));
        listaLivros.add(new Livro(R.drawable.oladofeiodoamor, "O lado feio do amor", "Colleen Hoover", "Galera", 2015));
        listaLivros.add(new Livro(R.drawable.todasassuasimperfeicoes, "Todas as suas (im)perfeições", "Colleen Hoover", "Galera", 2018));
        listaLivros.add(new Livro(R.drawable.verity, "Verity", "Colleen Hoover", "Galera", 2020));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
//        adapter = new RecyclerAdapter(listaLivros, this, this);

        setAdapter();
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(listaLivros, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickItem(int position) {
        listaLivros.remove(position);
        recyclerView.getAdapter().notifyItemRemoved(position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        recyclerView.getAdapter().notifyDataSetChanged();
    }
}