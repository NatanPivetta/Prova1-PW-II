package org.acme;

import java.util.ArrayList;
import java.util.List;

import org.acme.Music;

public class PlayList {
    private String nome;
    private String owner;
    private List<Music> musicas = new ArrayList<Music>();
    
    
    public PlayList(String nome, String owner, List<Music> musicas) {
        this.nome = nome;
        this.owner = owner;
        this.musicas = musicas;
    }
    
    public PlayList(){}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public List<Music> getMusicas() {
        return musicas;
    }
    public void setMusicas(Music music) {
        musicas.add(music);
    }

    
}
