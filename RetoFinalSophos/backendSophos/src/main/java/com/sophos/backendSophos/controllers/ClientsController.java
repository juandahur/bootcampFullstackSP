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
            validateClient(clientCreate);
            Clients temporal = clientsService.create(clientCreate);
            return ResponseEntity.created(new URI("/clients" + temporal.getId())).body(temporal);
            /*
            if (validateClient(clientCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
                */





        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    private void validateClient(ClientsCreateDto clientCreate) {

        //long diff = ChronoUnit.YEARS.between((Temporal) clientCreate.getBirthDate(),(Temporal) Date.from(Instant.now()));
        //return diff < 18;
        //return false;
        Date date1 = clientCreate.getBirthDate();
        System.out.println(date1);
        Date date2 = Date.from(Instant.now());
        System.out.println(date1 + " " +date2);
                LocalDate local1;
        local1 = date1.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate local2;
        local2 = date2.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        long diff = ChronoUnit.YEARS.between(local1,local2);

        System.out.println(local1 + " " + date1 + "  "+local2+ "  " +date2+ "  "+ diff);
    }

}
