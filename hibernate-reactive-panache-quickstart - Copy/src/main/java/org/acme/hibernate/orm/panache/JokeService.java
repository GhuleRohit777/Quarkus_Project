package org.acme.hibernate.orm.panache;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
public class JokeService {

    @Inject
    JokeRepository jokeRepository;

    @Inject
    @RestClient
    JokeApiClient jokeApiClient;

    @Transactional
    public Response fetchAndSaveJoke(int count) {
        int numberOfJokes = Math.min(count, 10);
        List<Joke> jokes = IntStream.range(0, numberOfJokes)
                .mapToObj(i -> {
                    JokeDTO jokeDTO = jokeApiClient.getRandomJoke();
                    Joke joke = new Joke(jokeDTO.setup, jokeDTO.punchline);
                    jokeRepository.persist(joke);
                    return joke;
                })
                .collect(Collectors.toList());

        // Return all saved jokes as the response
        return Response.ok(jokes).build();
    }


}