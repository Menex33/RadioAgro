package co.edu.unab.radioagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText correo, password;
    Button iniciarSesion, registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo = findViewById(R.id.et_correo);
        password = findViewById(R.id.et_password);
        iniciarSesion = findViewById(R.id.bt_iniciar_sesion);
        registrarse = findViewById(R.id.bt_registrarse);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miCorreo = correo.getText().toString();
                String miPassword = password.getText().toString();
                if (miCorreo.isEmpty() ||
                    miPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else {
                    UsuarioBD usuarioBD = UsuarioBD.getUsuarioBD(getApplicationContext());
                    UsuarioDAO usuarioDAO = usuarioBD.usuarioDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Usuario usuario = usuarioDAO.iniciarSasion(miCorreo, miPassword);
                            if (usuario==null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Correo o Contraseña invalida", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                String nombre = usuario.nombre;
                                startActivity(new Intent(
                                        LoginActivity.this, MainActivity.class)
                                        .putExtra("nombre", nombre));
                            }
                        }
                    }).start();
                }

            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistarUsuarioActivity.class));
            }
        });
    }
}