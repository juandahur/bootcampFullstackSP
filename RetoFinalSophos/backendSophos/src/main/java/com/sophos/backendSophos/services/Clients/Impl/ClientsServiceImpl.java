package com.sophos.backendSophos.services.Clients.Impl;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.repository.ClientsRepository;
import com.sophos.backendSophos.services.Clients.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Optional<Clients> getClientById(Long id){
        return clientsRepository.findById(id);
    }

    public Clients create(ClientsCreateDto client){
        return clientsRepository.save(createNewClient(client));
    }

    private Clients createNewClient(ClientsCreateDto client){
        Clients newClient = new Clients();
        newClient.setIdDocument(client.getIdDocument());
        newClient.setIdNumber(client.getIdNumber());
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setEmail(client.getEmail());
        newClient.setBirthDate(client.getBirthDate());
        newClient.setCreatedBy("Admin");
        newClient.setCreatedAt(LocalDate.now());
        newClient.setModifiedBy("Admin");
        newClient.setModifiedOn(LocalDate.now());
        return newClient;
    }

    public Clients update(ClientsUpdateDto client, Long id){
        Clients clientUpdate = findById(id).get();
        updateClient(clientUpdate, client);
        return clientsRepository.save(clientUpdate);
    }

    private Clients updateClient(Clients clientUpdate, ClientsUpdateDto client){
        clientUpdate.setIdDocument(client.getIdDocument());
        clientUpdate.setIdNumber(client.getIdNumber());
        clientUpdate.setFirstName(client.getFirstName());
        clientUpdate.setLastName(client.getLastName());
        clientUpdate.setEmail(client.getEmail());
        clientUpdate.setBirthDate(client.getBirthDate());
        clientUpdate.setModifiedBy("Admin");
        clientUpdate.setModifiedOn(LocalDate.now());

        return clientUpdate;
    }

    public Optional<Clients> findById(Long id){
        return clientsRepository.findById(id);
    }

    public void deleteById(Long id){
        clientsRepository.deleteById(id);
    }
}
