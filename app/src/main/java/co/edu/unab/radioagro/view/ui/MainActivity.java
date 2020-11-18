package co.edu.unab.radioagro.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.unab.radioagro.R;
import co.edu.unab.radioagro.model.entity.Emisora;
import co.edu.unab.radioagro.view.adapter.EmisoraAdapter;

public class MainActivity extends AppCompatActivity {

    static TextView tvNombreUsuario;
    Button btFavoritos, btRadio;
    RecyclerView rvEmisoras;
    ArrayList<Emisora> emisoras, favoritos;
    EmisoraAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEmisoras = findViewById(R.id.rv_emisoras);
        btFavoritos = findViewById(R.id.bt_favoritos);
        btRadio = findViewById(R.id.bt_radio);

        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario);
        String nombre = getIntent().getStringExtra("nombre");
        tvNombreUsuario.setText(nombre);

        emisoras = new ArrayList<>();
        favoritos = new ArrayList<>();

        cargarEmisoras();

        adapter = new EmisoraAdapter(emisoras);

        rvEmisoras.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvEmisoras.setHasFixedSize(true);
        rvEmisoras.setAdapter(adapter);

        btRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RadioActivity.class));
            }
        });

        btFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FavoritosActivity.class));
            }
        });

    }

    private void cargarEmisoras() {

        Emisora em1 = new Emisora( 1, "https://static-media.streema.com/media/cache/72/1d/721df26610301b16ab6d50793e8121ae.jpg",
                "Barranquilla Stereo",
                "Musica tropical de la costa caribe colombiana",
                "https://radio.yaservers.com/8197/;");
        Emisora em2 = new Emisora( 2, "https://www.unab.edu.co/sites/default/files/imagenes/dependencia_logo/10828012_741229645965058_2293662817237574795_o.jpg",
                "UNAB Radio",
                "Radio Universitaria de Bucaramanga",
                "https://node-23.zeno.fm/yx8s10hs0wzuv?rj-ttl=5&rj-tok=AAABddrMaRoAYpWEDcRY2WJM0g");
        Emisora em3 = new Emisora( 3, "https://is5-ssl.mzstatic.com/image/thumb/Purple62/v4/c8/e4/1c/c8e41ca8-8745-4272-b2ea-5bbf1d5adce8/source/512x512bb.jpg",
                "Smooth Jazz NY",
                "Jazz Music from New York",
                "https://us3.internet-radio.com/proxy/cd1019?mp=/stream;");
        Emisora em4 = new Emisora( 4, "https://is2-ssl.mzstatic.com/image/thumb/Purple123/v4/4a/cb/b4/4acbb489-406a-bd6a-fc6f-2adef1f95697/source/512x512bb.jpg",
                "Classic Rock Florida",
                "Tropical Waves of Classic Rock with Hits from the 60's, 70's, 80's through today!",
                "https://us4.internet-radio.com/proxy/douglassinclair?mp=/stream;");
        Emisora em5 = new Emisora( 5, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/La_FM_logo.svg/1200px-La_FM_logo.svg.png",
                "La FM",
                "Emisora de radio colombiana de programación generalista",
                "https://21933.live.streamtheworld.com/LA_FM_BOGAAC_SC");

        emisoras.add(em1);
        emisoras.add(em2);
        emisoras.add(em3);
        emisoras.add(em4);
        emisoras.add(em5);

    }

    public void agregarFavorito (View view, int position) {

        Toast.makeText(this,"Emisora Agregada", Toast.LENGTH_SHORT).show();
    }
}