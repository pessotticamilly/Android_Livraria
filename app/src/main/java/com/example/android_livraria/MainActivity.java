package com.example.android_livraria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Livro> listaLivros;

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
        listaLivros.add(new Livro(R.drawable.asmilpartesdomeucoracao, "As mil partes do meu coração", "Colleen Hoover", "Galera", 2017));
        listaLivros.add(new Livro(R.drawable.eassimqueacaba, "É assim que acaba", "Colleen Hoover", "Galera", 2018));
        listaLivros.add(new Livro(R.drawable.eassimquecomeca, "É assim que começa", "Colleen Hoover", "Galera", 2022));
        listaLivros.add(new Livro(R.drawable.novembro9, "Novembro, 9", "Colleen Hoover", "Galera", 2015));
        listaLivros.add(new Livro(R.drawable.oladofeiodoamor, "O lado feio do amor", "Colleen Hoover", "Galera", 2015));
        listaLivros.add(new Livro(R.drawable.todasassuasimperfeicoes, "Todas as suas (im)perfeições", "Colleen Hoover", "Galera", 2018));
        listaLivros.add(new Livro(R.drawable.verity,"Verity", "Colleen Hoover", "Galera", 2020));
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(listaLivros, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}