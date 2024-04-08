package org.acme;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.acme.Music;

@Path("/playlist")
public class PlaylistService {

    @Inject
    @RestClient
    AddMusic service;

    List<PlayList> playLists = new ArrayList<PlayList>();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlayList> create(
            @FormParam("name") String name,
            @FormParam("owner") String owner) {

        PlayList playlist = new PlayList();
        playlist.setNome(name);
        playlist.setOwner(owner);
        playLists.add(playlist);
        return playLists;

    }

    @POST
    @Path("/addMusic")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)

    public PlayList addMusic(
            @FormParam("playListName") String name,
            @FormParam("musicName") String musicName) {

        PlayList playlist = new PlayList();
        for (PlayList item : this.playLists) {
            if (item.getNome().equals(name)) {
                System.out.println("pl"+item.getNome());
                playlist.setNome(item.getNome());
                playlist.setOwner(item.getOwner());
            }
        }
        System.out.println("Enviando para servico de catalogo");

        Music result = service.addMusic(musicName);
        System.out.println(result.getTitulo());
        playlist.setMusicas(result);
        return playlist;
    }
}
