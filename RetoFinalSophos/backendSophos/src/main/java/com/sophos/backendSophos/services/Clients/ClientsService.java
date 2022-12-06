package com.sophos.backendSophos.services.Clients;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;
import com.sophos.backendSophos.models.Clients;

import java.util.List;
import java.util.Optional;

public interface ClientsService {

    List<Clients> getAllClients ();
    Clients create(ClientsCreateDto client);

    Clients update(ClientsUpdateDto client, Long id);

    void deleteById(Long id);

    Optional<Clients> findById(Long id);



}
