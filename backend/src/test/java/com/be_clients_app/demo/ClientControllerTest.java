package com.be_clients_app.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.be_clients_app.demo.Controller.ClientController;
import com.be_clients_app.demo.Dto.ClientResponseDto;
import com.be_clients_app.demo.Service.ClientService;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public ClientService clientService() {
            return mock(ClientService.class);
        }
    }

    @Autowired
    private ClientService clientService;

    @Test
    void searchClients_ReturnsClients() throws Exception {
        
        ClientResponseDto mockClient = new ClientResponseDto(
            "Othmane",
            "Dr",
            "oth.dr@email.com"
            );
        when(clientService.searchClients("test"))
            .thenReturn(List.of(mockClient));

        mockMvc.perform(get("/api/v1/clients/search")
                .param("name", "test")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nom").value(mockClient.getNom()))
            .andExpect(jsonPath("$[0].prenom").value(mockClient.getPrenom()))
            .andExpect(jsonPath("$[0].email").value(mockClient.getEmail()));
    }

    @Test
    void searchClients_EmptyName_ReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/v1/clients/search")
                .param("prenom", "")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }
}