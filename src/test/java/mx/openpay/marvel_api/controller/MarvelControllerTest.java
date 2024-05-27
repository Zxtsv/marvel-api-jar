package mx.openpay.marvel_api.controller;

import mx.openpay.marvel_api.controllers.MarvelController;
import mx.openpay.marvel_api.services.MarvelService;
import mx.openpay.marvel_api.wrappers.CharacterDataWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MarvelControllerTest {

    @Mock
    private MarvelService marvelService;

    @InjectMocks
    private MarvelController marvelController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(marvelController).build();
    }

    @Test
    void testGetCharacters() throws Exception {
        // Given
        CharacterDataWrapper mockResponse = new CharacterDataWrapper();
        when(marvelService.getCharacters(anyMap())).thenReturn(mockResponse);

        // When & Then
        mockMvc.perform(get("/api/marvel/characters")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCharacterById() throws Exception {
        CharacterDataWrapper mockResponse = new CharacterDataWrapper();
        when(marvelService.getCharacterById(1011334L)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/marvel/characters/1011334")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}