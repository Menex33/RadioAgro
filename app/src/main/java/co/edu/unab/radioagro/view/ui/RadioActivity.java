package co.edu.unab.radioagro.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import co.edu.unab.radioagro.R;

public class RadioActivity extends AppCompatActivity {

    ImageButton btPlay, btNext, btPrevious;
    Button btEmisoras, btFavoritos;

    MediaPlayer mediaPlayer;
    boolean preparar, empezar=false;

    String stream = "https://radio.yaservers.com/8197/;   ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        btPlay = findViewById(R.id.bt_play);
        btNext = findViewById(R.id.bt_next);
        btEmisoras = findViewById(R.id.bt_Emisoras);
        btFavoritos = findViewById(R.id.bt_favoritos);
        btPrevious = findViewById(R.id.bt_previous);

        Toast toast=Toast.makeText(getApplicationContext(),"Esperando respuesta del servidor...",Toast.LENGTH_LONG);
        toast.show();

        btPlay.setEnabled(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        new PlayerTask().execute(stream);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empezar){
                    empezar=false;
                    mediaPlayer.pause();
                    btPlay.setBackgroundResource(R.drawable.ic_play);
                    Toast toast=Toast.makeText(getApplicationContext(),"Pausa",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    empezar=true;
                    mediaPlayer.start();
                    btPlay.setBackgroundResource(R.drawable.ic_pause);
                    Toast toast=Toast.makeText(getApplicationContext(),"Play",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btEmisoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                startActivity(new Intent(RadioActivity.this, MainActivity.class));
            }
        });

        btFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                startActivity(new Intent(RadioActivity.this, FavoritosActivity.class));
            }
        });
    }

    private class PlayerTask extends AsyncTask<String,Void,Boolean> {
        @Override
        protected Boolean doInBackground(String... strings){
            try{
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                preparar=true;
            }catch(IOException e){
                e.printStackTrace();
            }
            return preparar;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean){
            super.onPostExecute(aBoolean);
            btPlay.setBackgroundResource(R.drawable.ic_pause);
            mediaPlayer.start();
            btPlay.setEnabled(true);
        }
    }
}