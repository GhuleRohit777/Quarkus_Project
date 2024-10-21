package org.acme.hibernate.orm.panache;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jokes")
public class JokeResource {

    @Inject
    JokeService jokeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchJokes(@QueryParam("count") int count) {
        if (count <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The count parameter must be a positive number.")
                    .build();
        }
      return jokeService.fetchAndSaveJoke(count);
    }
}
