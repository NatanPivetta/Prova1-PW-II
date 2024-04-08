package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import org.acme.Music;

@RegisterRestClient(baseUri = "http://localhost:8083/music")

public interface AddMusic {
    
    @GET
    @Path("/get")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)

    Music addMusic (
        @QueryParam("titulo") String titulo
    );



}
