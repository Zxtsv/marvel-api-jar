package mx.openpay.marvel_api.controllers;


import mx.openpay.marvel_api.services.MarvelService;
import mx.openpay.marvel_api.wrappers.CharacterDataWrapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/marvel")
public class MarvelController {

    private final MarvelService marvelService;

    public MarvelController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @GetMapping("/characters")
    public CharacterDataWrapper getCharacters(@RequestParam Map<String, String> params) {
        return marvelService.getCharacters(params);
    }

    @GetMapping("/characters/{characterId}")
    public CharacterDataWrapper getCharacterById(@PathVariable Long characterId) {
        return marvelService.getCharacterById(characterId);
    }
}