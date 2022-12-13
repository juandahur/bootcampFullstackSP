package com.sophos.backendSophos.services.Clients;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;

public interface ClientsValidationsService {

    boolean validateClientCreate(ClientsCreateDto clientCreate);

    boolean validateClientUpdate(ClientsUpdateDto clientUpdate);

    boolean validateClientDelete(Long id);

}