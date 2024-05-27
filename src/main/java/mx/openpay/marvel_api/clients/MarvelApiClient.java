package mx.openpay.marvel_api.clients;


import mx.openpay.marvel_api.wrappers.CharacterDataWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "marvelClient", url = "https://gateway.marvel.com")
public interface MarvelApiClient {

    @GetMapping("/v1/public/characters")
    CharacterDataWrapper getCharacters(@RequestParam Map<String, String> params);

    @GetMapping("/v1/public/characters/{characterId}")
    CharacterDataWrapper getCharacterById(@PathVariable("characterId") Long characterId,
                                          @RequestParam("apikey") String apiKey,
                                          @RequestParam("ts") String timestamp,
                                          @RequestParam("hash") String hash);
}
