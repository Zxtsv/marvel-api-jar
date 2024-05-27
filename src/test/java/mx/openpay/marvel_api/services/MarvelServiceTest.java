package mx.openpay.marvel_api.services;

import mx.openpay.marvel_api.clients.MarvelApiClient;
import mx.openpay.marvel_api.wrappers.CharacterDataWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class MarvelServiceTest {

    @Mock
    private MarvelApiClient marvelApiClient;

    @InjectMocks
    private MarvelService marvelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCharacters() {
        CharacterDataWrapper mockResponse = new CharacterDataWrapper();
        when(marvelApiClient.getCharacters(anyMap())).thenReturn(mockResponse);

        Map<String, String> filters = new HashMap<>();
        CharacterDataWrapper result = marvelService.getCharacters(filters);

        assertNotNull(result);
    }
}
