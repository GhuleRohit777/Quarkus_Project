package org.acme.hibernate.orm.panache;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://official-joke-api.appspot.com")
public interface JokeApiClient {

    @GET
    @Path("/random_joke")
    JokeDTO getRandomJoke();
}
