package com.sophos.backendSophos.services.Clients.Impl;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.repository.ClientsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class ClientsServiceImplTest {

    @Mock
    private ClientsRepository clientsRepository;

    @InjectMocks
    private ClientsServiceImpl clientsServiceImpl;

    private Clients client;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        client = new Clients();
        client.setId(1L);
        client.setIdDocument("111111111");
        client.setFirstName("Juan");
        client.setLastName("Hurtado");
        client.setEmail("juan@gmail.com");
        client.setBirthDate(LocalDate.parse("1985-01-12"));
        client.setCreatedBy("Admin");
        client.setCreatedAt(LocalDate.now());
        client.setModifiedBy("Admin");
        client.setModifiedOn(LocalDate.now());

    }
    @Test
    void getAllClients() {
        when(clientsRepository.findAll()).thenReturn(Arrays.asList(client));
        assertNotNull(clientsServiceImpl.getAllClients());
    }

    @Test
    void getClientById(){
        when(clientsRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        assertNotNull(clientsServiceImpl.getClientById(1L));
    }

    @Test
    void create(){
        when(clientsRepository.save(any(Clients.class))).thenReturn(client);
        assertNotNull(clientsServiceImpl.create(new ClientsCreateDto()));
    }

    @Test
    void update(){
        when(clientsRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        when(clientsRepository.save(any(Clients.class))).thenReturn(client);
        assertNotNull(clientsServiceImpl.update(new ClientsUpdateDto(),1L));
    }

    @Test
    void deleteById(){
        clientsServiceImpl.deleteById(1L);
        verify(clientsRepository,times(1)).deleteById(1L);

    }

}