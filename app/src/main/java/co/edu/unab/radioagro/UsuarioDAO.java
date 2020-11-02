package co.edu.unab.radioagro;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDAO {

    @Insert
    void registrarUsuario (Usuario Usuario);

    @Query("SELECT * from usuarios where correo=(:correo) and password=(:password)")
    Usuario iniciarSasion(String correo, String password);

}
