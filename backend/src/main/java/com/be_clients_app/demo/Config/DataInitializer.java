package com.be_clients_app.demo.Config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.be_clients_app.demo.Entity.Client;
import com.be_clients_app.demo.Repository.ClientRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final ClientRepository clientRepo;
    
    public DataInitializer(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }
    
    @Override
    public void run(String... args) {
        if (clientRepo.count() == 0) {
            clientRepo.saveAll(List.of(
                new Client("Derrar", "Othmane", "oth.derrar@gmail.com"),
                new Client("Hjira", "Saad", "hjira@example.com")
            ));
        }
    }
}