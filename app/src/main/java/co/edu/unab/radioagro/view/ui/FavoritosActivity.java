package co.edu.unab.radioagro.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.edu.unab.radioagro.R;

public class FavoritosActivity extends AppCompatActivity {

    TextView tvNombreUsuario;
    Button btRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario);
        String nombre = getIntent().getStringExtra("nombre");
        tvNombreUsuario.setText(nombre);

        btRadio = findViewById(R.id.bt_radio);

        btRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoritosActivity.this, RadioActivity.class));
            }
        });
    }
}