package com.be_clients_app.demo.Service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.be_clients_app.demo.Dto.ClientResponseDto;
import com.be_clients_app.demo.Entity.Client;
import com.be_clients_app.demo.Exception.ClientNotFoundException;
import com.be_clients_app.demo.Mapper.ClientMapper;
import com.be_clients_app.demo.Repository.ClientRepository;
import com.be_clients_app.demo.Service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ClientResponseDto> searchClients(String keyword) {
        List<Client> clients = repository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(keyword, keyword);

        if (clients.isEmpty()) {
            throw new ClientNotFoundException("No client found for: " + keyword);
        }

        return mapper.toDtoList(clients);
    }
}
