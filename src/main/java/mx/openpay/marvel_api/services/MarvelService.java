package mx.openpay.marvel_api.services;

import mx.openpay.marvel_api.clients.MarvelApiClient;
import mx.openpay.marvel_api.wrappers.CharacterDataWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Service
public class MarvelService {

    @Value("${marvel.public.key}")
    private String publicKey;

    @Value("${marvel.private.key}")
    private String privateKey;

    private final MarvelApiClient marvelApiClient;

    public MarvelService(MarvelApiClient marvelApiClient) {
        this.marvelApiClient = marvelApiClient;
    }

    public CharacterDataWrapper getCharacters(Map<String, String> filters) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String hash = generateHash(timestamp);
        filters.put("apikey", publicKey);
        filters.put("ts", timestamp);
        filters.put("hash", hash);
        return marvelApiClient.getCharacters(filters);
    }

    public CharacterDataWrapper getCharacterById(Long characterId) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String hash = generateHash(timestamp);
        return marvelApiClient.getCharacterById(characterId, publicKey, timestamp, hash);
    }

    private String generateHash(String timestamp) {
        try {
            String value = timestamp + privateKey + publicKey;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder hash = new StringBuilder();
            for (byte b : hashBytes) {
                hash.append(String.format("%02x", b));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}