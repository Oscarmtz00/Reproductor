package com.example.reproductor;

import android.os.Bundle;

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

        btn_playpausa = (Button) findViewById(R.id.btn_play_pausa);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);

    }
}