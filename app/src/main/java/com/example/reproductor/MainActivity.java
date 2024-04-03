package com.example.reproductor;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_playpausa, btn_repetir, btn_stop, btn_anterior, btn_siguiente;
    MediaPlayer mp;
    ImageView iv;
    int repetir, posicion=0;

    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_playpausa = (Button) findViewById(R.id.btn_play_pausa);
        btn_playpausa.setOnClickListener(this::Play);

        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        btn_repetir.setOnClickListener(this::Repetir);

        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(this::Stop);

        btn_anterior = (Button) findViewById(R.id.btn_anterior);
        btn_anterior.setOnClickListener(this::Anterior);

        btn_siguiente = (Button) findViewById(R.id.btn_siguiente);
        btn_siguiente.setOnClickListener(this::Siguiente);


        iv= (ImageView) findViewById(R.id.imageView);

        vectormp[0]=MediaPlayer.create(this, R.raw.race);
        vectormp[1]=MediaPlayer.create(this, R.raw.sound);
        vectormp[2]=MediaPlayer.create(this, R.raw.tea);
    }

    //Metodo para el boton Play

    public void Play (View view){

        if (vectormp [posicion].isPlaying()){
            vectormp [posicion].pause();
            btn_playpausa.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else {
            vectormp[posicion].start();
            btn_playpausa.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton Stop

    public void Stop(View view) {

        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this, R.raw.race);
            vectormp[1]=MediaPlayer.create(this, R.raw.sound);
            vectormp[2]=MediaPlayer.create(this, R.raw.tea);
            posicion=0;
            btn_playpausa.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton Repetir

    public void Repetir(View view){

        if (repetir==1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir=2;
        }else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir=1;
        }
    }

    //Metodo para el boton Siguiente

    public void Siguiente(View view){

        if(posicion< vectormp.length -1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if (posicion==0){
                    iv.setImageResource(R.drawable.portada1);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }else {
                posicion++;

                if (posicion==1){
                    iv.setImageResource(R.drawable.portada1);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        }else {
            Toast.makeText(this, "No se encuentran mas canciones para reproducir", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton anterior

    public void Anterior(View view){

        if(posicion>=1){
            if (vectormp [posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this, R.raw.race);
                vectormp[1]=MediaPlayer.create(this, R.raw.sound);
                vectormp[2]=MediaPlayer.create(this, R.raw.tea);
                posicion--;
            }
        }else {
            Toast.makeText(this, "No existen mas canciones para reproducir", Toast.LENGTH_SHORT).show();
        }
    }
}