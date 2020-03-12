package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }


    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];

        switch ( escolhaApp ) {
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }
            if (
                    (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                    (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                    (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
                    ){//App Ganhador
                textResultado.setText("Você Perdeu :) ");
            }else if (
                    (escolhaUsuario == "Tesoura" && escolhaApp == "Pedra") ||
                    (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                    (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
                    ){//Usuario Ganhador
                textResultado.setText("Você Ganhou! :) ");
            } else {//Empate
                textResultado.setText("Nós empatamos");
            }

    }


}

