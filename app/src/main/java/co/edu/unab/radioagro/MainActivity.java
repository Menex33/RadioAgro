package co.edu.unab.radioagro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario);
        String nombre = getIntent().getStringExtra("nombre");
        tvNombreUsuario.setText(nombre);


    }
}