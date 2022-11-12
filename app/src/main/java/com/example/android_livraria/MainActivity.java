package com.example.android_livraria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Livro> listaLivros;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        listaLivros = new ArrayList<>();

        setLivrosLista();
        setAdapter();
    }

    private void setLivrosLista() {
        listaLivros.add(new Livro(123456, "O lado feio do amor", "Collen Hoover", "Galera", 413));
        listaLivros.add(new Livro(123456, "É assim que acaba", "Collen Hoover", "Galera", 374));
        listaLivros.add(new Livro(123456, "Todas as suas (im)perfeições", "Collen Hoover", "Galera", 284));
        listaLivros.add(new Livro(123456, "Verity", "Collen Hoover", "Galera", 277));
        listaLivros.add(new Livro(123456, "É assim que começa", "Collen Hoover", "Galera", 332));
        listaLivros.add(new Livro(123456, "As mil partes do meu coração", "Collen Hoover", "Galera", 269));
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(listaLivros);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}