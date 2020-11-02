package co.edu.unab.radioagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistarUsuarioActivity extends AppCompatActivity {

    EditText nombre, correo, password;
    Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_usuario);

        nombre = findViewById(R.id.et_nombreu);
        correo = findViewById(R.id.et_correou);
        password = findViewById(R.id.et_passwordu);

        registrar = findViewById(R.id.bt_registrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario();
                usuario.setNombre(nombre.getText().toString());
                usuario.setCorreo(correo.getText().toString());
                usuario.setPassword(password.getText().toString());
                if (validarUsuario(usuario)){
                    UsuarioBD usuarioBD = UsuarioBD.getUsuarioBD(getApplicationContext());
                    UsuarioDAO usuarioDAO = usuarioBD.usuarioDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            usuarioDAO.registrarUsuario(usuario);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Usuario Registrado", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }else {
                    Toast.makeText(getApplicationContext(), "Favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private Boolean validarUsuario(Usuario usuario){
        if (usuario.getNombre().isEmpty() ||
            usuario.getCorreo().isEmpty() ||
            usuario.getPassword().isEmpty()){
            return false;
        }
        return true;
    }

}