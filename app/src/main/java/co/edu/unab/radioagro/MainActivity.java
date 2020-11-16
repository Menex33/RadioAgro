package co.edu.unab.radioagro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvNombreUsuario;
    Button btFavoritos, btRadio;
    RecyclerView rvEmisoras;
    ArrayList<Emisora> emisoras;
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

        cargarEmisoras();

        adapter = new EmisoraAdapter(emisoras);

        rvEmisoras.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvEmisoras.setHasFixedSize(true);
        rvEmisoras.setAdapter(adapter);

    }

    private void cargarEmisoras() {

        Emisora em1 = new Emisora("https://is2-ssl.mzstatic.com/image/thumb/Purple123/v4/4a/cb/b4/4acbb489-406a-bd6a-fc6f-2adef1f95697/source/512x512bb.jpg",
                "Classic Rock Florida",
                "Tropical Waves of Classic Rock with Hits from the 60's, 70's, 80's through today!",
                "https://www.classicrockflorida.com/");

        emisoras.add(em1);

    }
}