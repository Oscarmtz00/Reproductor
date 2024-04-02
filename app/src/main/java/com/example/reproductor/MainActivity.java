package com.example.reproductor;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_playpausa, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir, posicion=0;

    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);

        btn_playpausa= (Button) findViewById(R.id.btn_play_pausa);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
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
            Toast.makeText(this, "Play", Toast.LENGHT_SHORT).show();
        }
    }
}