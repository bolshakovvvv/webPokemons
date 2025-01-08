package kseoni.ch.pkmn.services;

import kseoni.ch.pkmn.clients.PokemonTcgClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonTcgService {

    private final PokemonTcgClient pokemonTcgClient;

    public String fetchCardImageByName(String name) {
        return pokemonTcgClient.getCardImageByName(name);
    }
}