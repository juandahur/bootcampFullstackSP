package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.dto.Clients.ClientsCreateDto;
import com.sophos.backendSophos.dto.Clients.ClientsUpdateDto;
import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.services.Clients.ClientsService;
import com.sophos.backendSophos.services.Clients.ClientsValidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @Autowired
    ClientsValidationsService clientsValidationsService;

    @GetMapping
    private ResponseEntity<List<Clients>> listClients(){
        return ResponseEntity.ok(clientsService.getAllClients());
    }

    @PostMapping
    private ResponseEntity save(@RequestBody ClientsCreateDto clientCreate) {
        try {
            if(clientsValidationsService.validateClientCreate(clientCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El cliente debe ser mayor de edad");
            }
            Clients temporal = clientsService.create(clientCreate);
            return ResponseEntity.created(new URI("/clients" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // UPDATE
    @PatchMapping("/{id}")
    private ResponseEntity update(@RequestBody ClientsUpdateDto clientUpdate, @PathVariable Long id) {
        try {
            if(clientsValidationsService.validateClientUpdate(clientUpdate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El cliente debe ser mayor de edad");
            }
            Clients temporal = clientsService.update(clientUpdate, id);
            return ResponseEntity.created(new URI("/clients" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    //DELETE
    @DeleteMapping("/{id}")
    private ResponseEntity deleteById(@PathVariable Long id) {
        try {
            if (clientsValidationsService.validateClientDelete(id)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("At least one product don't Cancelled");
            }
            clientsService.deleteById(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}