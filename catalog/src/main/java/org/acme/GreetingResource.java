package org.acme;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import main.java.org.acme.Music;



@Path("/music")
public class Catalog {


    List<Music> catalogo = new ArrayList<Music>();
    
    @POST
    @Path("/add")
    @Consumes(MediaType.FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    
    public List<Music> add(
        @FormParams("titulo") String titulo,
        @FormParams("artista") String artista)
     {
        Music music = new Music(titulo, artista);
        catalogo.add(music);
        
        return catalogo;
    }
}
