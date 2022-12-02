package com.sophos.backendSophos.services.Clients;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.models.Clients;

import java.util.List;

public interface ClientsService {

    List<Clients> getAllClients ();
    Clients create(ClientsCreateDto client);


}
