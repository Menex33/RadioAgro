package co.edu.unab.radioagro.model.entity;

public class Emisora {

    String imagenEmisora, nombreEmisora, descripcionEmisora, urlEmisora;
    Integer idEmisora;

    public Emisora() {
    }

    public Emisora(Integer idEmisora, String imagenEmisora, String nombreEmisora, String descripcionEmisora, String urlEmisora) {
        this.idEmisora = idEmisora;
        this.imagenEmisora = imagenEmisora;
        this.nombreEmisora = nombreEmisora;
        this.descripcionEmisora = descripcionEmisora;
        this.urlEmisora = urlEmisora;
    }

    public Integer getIdEmisora() {
        return idEmisora;
    }

    public String getImagenEmisora() {
        return imagenEmisora;
    }

    public String getNombreEmisora() {
        return nombreEmisora;
    }

    public String getDescripcionEmisora() {
        return descripcionEmisora;
    }

    public String getUrlEmisora() {
        return urlEmisora;
    }
}
