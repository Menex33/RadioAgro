package co.edu.unab.radioagro;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class}, version = 1)
public abstract class UsuarioBD extends RoomDatabase {

    private static final String datos = "usuario";
    private static UsuarioBD usuarioBD;

    public static synchronized UsuarioBD getUsuarioBD(Context miContexto){

        if(usuarioBD==null){
            usuarioBD = Room.databaseBuilder(miContexto, UsuarioBD.class, datos)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return usuarioBD;
    }

    public abstract UsuarioDAO usuarioDAO();

}
