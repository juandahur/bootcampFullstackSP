package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.services.Clients.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @GetMapping
    private ResponseEntity<List<Clients>> listClients(){
        return ResponseEntity.ok(clientsService.getAllClients());
    }

    @PostMapping
    private ResponseEntity<Clients> save(@RequestBody ClientsCreateDto clientCreate) {


        try {
            if(validateClient(clientCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Clients temporal = clientsService.create(clientCreate);
            return ResponseEntity.created(new URI("/clients" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    private boolean validateClient(ClientsCreateDto clientCreate) {

        LocalDate date1 = clientCreate.getBirthDate();
        LocalDate date2 = LocalDate.now();
        long diff = ChronoUnit.YEARS.between(date1,date2);
        System.out.println("Fecha nacimiento " + date1 + "  "+ "Hoy:   " +date2+ " Diferencia:  "+ diff);

        return (diff<18);


    }

}
