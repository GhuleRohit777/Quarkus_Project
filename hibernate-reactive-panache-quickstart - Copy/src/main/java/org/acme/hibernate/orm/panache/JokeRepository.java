package org.acme.hibernate.orm.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JokeRepository implements PanacheRepository<Joke> {
    // You can add custom methods here if needed
}
