package com.be_clients_app.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.be_clients_app.demo.Dto.ClientResponseDto;
import com.be_clients_app.demo.Service.ClientService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/v1/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/search")
    public ResponseEntity<List<ClientResponseDto>> search(
            @RequestParam 
            @NotBlank(message = "Name parameter is required") 
            @Size(min = 1, message = "Query must be at least 1 characters")
            String name) {
        
        return ResponseEntity.ok(clientService.searchClients(name));
    }
}
