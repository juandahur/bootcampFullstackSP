package com.sophos.backendSophos.services.Clients.Impl;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.repository.ClientsRepository;
import com.sophos.backendSophos.services.Clients.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;


    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Clients create(ClientsCreateDto client){
        Clients newClient = new Clients();
        newClient.setIdDocument(client.getIdDocument());
        newClient.setIdNumber(client.getIdNumber());
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setEmail(client.getEmail());
        newClient.setBirthDate(client.getBirthDate());
        newClient.setCreatedBy("Admin");
        newClient.setCreatedAt(Date.from(Instant.now()));
        newClient.setModifiedBy("Admin");
        newClient.setModifiedOn(Date.from(Instant.now()));

        return clientsRepository.save(newClient);
    }

}
