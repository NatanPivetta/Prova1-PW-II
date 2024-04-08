package org.acme;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.acme.Music;

@Path("/music")
public class Catalog {

    List<Music> catalogo = new ArrayList<Music>();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)

    public List<Music> add(
            @FormParam("titulo") String titulo,
            @FormParam("artista") String artista) {
        Music music = new Music(titulo, artista);
        catalogo.add(music);

        return catalogo;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Music get(@QueryParam("titulo") String titulo) {
        Music music = new Music();
        for (Music item : this.catalogo) {
            if (item.getTitulo().equals(titulo)) {
                music.setArtista(item.getArtista());
                music.setTitulo(item.getTitulo());
            }
        }
        
        return music;
    }

}
