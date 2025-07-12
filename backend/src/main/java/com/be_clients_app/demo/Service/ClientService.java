package com.be_clients_app.demo.Service;

import java.util.List;

import com.be_clients_app.demo.Dto.ClientResponseDto;

public interface ClientService {

    List<ClientResponseDto> searchClients(String keyword);
    
}

