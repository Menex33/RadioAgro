package co.edu.unab.radioagro.model.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.edu.unab.radioagro.model.entity.Usuario;

@Dao
public interface UsuarioDAO {

    @Insert
    void registrarUsuario (Usuario Usuario);

    @Query("SELECT * from usuarios where correo=(:correo) and password=(:password)")
    Usuario iniciarSesion(String correo, String password);

}
