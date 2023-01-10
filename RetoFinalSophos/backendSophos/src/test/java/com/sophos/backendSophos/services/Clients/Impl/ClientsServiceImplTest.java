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
import java.util.List;
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
        List<Clients> clientsList= clientsServiceImpl.getAllClients();
        assertNotNull(clientsList);
        assertEquals(clientsList.stream().count(), 1);
    }

    @Test
    void getClientById(){
        when(clientsRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        Optional<Clients> newClient = clientsServiceImpl.getClientById(1L);
        assertNotNull(newClient);
        assertEquals(newClient.stream().count(), 1);
        assertEquals(newClient.get().getFirstName(), client.getFirstName());
    }

    @Test
    void create(){
        when(clientsRepository.save(any(Clients.class))).thenReturn(client);
        Clients newClient = clientsServiceImpl.create(new ClientsCreateDto());
        assertEquals(newClient.getFirstName(), client.getFirstName());
        assertNotNull(newClient);
        assertEquals(newClient.getFirstName(), client.getFirstName());
    }

    @Test
    void update(){
        when(clientsRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
        when(clientsRepository.save(any(Clients.class))).thenReturn(client);
        Clients newClient = clientsServiceImpl.update(new ClientsUpdateDto(),1L);
        assertNotNull(newClient);
        assertEquals(newClient.getFirstName(), client.getFirstName());
        verify(clientsRepository,times(1)).save(any(Clients.class));
    }

    @Test
    void deleteById(){
        assertDoesNotThrow(() ->{
            clientsServiceImpl.deleteById(1L);
        });
        verify(clientsRepository,times(1)).deleteById(1L);

    }
}