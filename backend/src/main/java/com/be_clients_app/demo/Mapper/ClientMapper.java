package com.be_clients_app.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.be_clients_app.demo.Dto.ClientResponseDto;
import com.be_clients_app.demo.Entity.Client;

@Component
public class ClientMapper {

    public ClientResponseDto toDto(Client client) {
        if (client == null) return null;
        return new ClientResponseDto(client.getNom(), client.getPrenom(), client.getEmail());
    }

    public List<ClientResponseDto> toDtoList(List<Client> clients) {
        return clients.stream()
                      .map(this::toDto)
                      .collect(Collectors
                      .toList());
    }

    
    public Client toEntity(ClientResponseDto dto) {
        if (dto == null) return null;
        Client client = new Client();
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        return client;
    }
    
}
