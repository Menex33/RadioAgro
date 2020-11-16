package co.edu.unab.radioagro;

public class Emisora {

    String imagenEmisora, nombreEmisora, descripcionEmisora, urlEmisora;

    public Emisora() {
    }

    public Emisora(String imagenEmisora, String nombreEmisora, String descripcionEmisora, String urlEmisora) {
        this.imagenEmisora = imagenEmisora;
        this.nombreEmisora = nombreEmisora;
        this.descripcionEmisora = descripcionEmisora;
        this.urlEmisora = urlEmisora;
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
