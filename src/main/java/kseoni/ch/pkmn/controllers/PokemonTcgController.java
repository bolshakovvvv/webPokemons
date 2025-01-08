package kseoni.ch.pkmn.controllers;

import kseoni.ch.pkmn.clients.PokemonTcgClient;
import kseoni.ch.pkmn.services.PokemonTcgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tcg")
@RequiredArgsConstructor
public class PokemonTcgController {

    private final PokemonTcgService pokemonTcgService;

    @GetMapping("/card-image/{name}")
    public ResponseEntity<String> getCardImageByName(@PathVariable String name) {
        String imageUrl = pokemonTcgService.fetchCardImageByName(name);
        if (imageUrl == null || imageUrl.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imageUrl);
    }
}
