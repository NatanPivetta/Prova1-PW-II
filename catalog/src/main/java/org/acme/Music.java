package main.java.org.acme;

public class Music {

    private String titulo;
    private String artista;
   
   

    
    public Music(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    
    
}
