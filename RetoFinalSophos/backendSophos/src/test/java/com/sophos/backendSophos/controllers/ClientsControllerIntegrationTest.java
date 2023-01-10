package com.sophos.backendSophos.controllers;

import com.sophos.backendSophos.models.Clients;
import com.sophos.backendSophos.services.Clients.ClientsService;
import com.sophos.backendSophos.services.Clients.ClientsValidationsService;
import com.sophos.backendSophos.services.Clients.Impl.ClientsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientsController.class)
public class ClientsControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientsService clientsService;;

    @MockBean
    private ClientsValidationsService clientsValidationsService;


    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        Clients clientTest = new Clients(

                "CE",
                "4556677566",
                "Juan",
                "Serna",
                "juan@gmail.com",
                LocalDate.parse("1985-01-17"),
                LocalDate.parse("2022-12-07"),
                "Admin",
                LocalDate.parse("2022-12-16"),
                "Admin",
                new ArrayList<>()

        );

        List<Clients> allClients = Arrays.asList(clientTest);

        given(clientsService.getAllClients()).willReturn(allClients);

        mvc.perform(get("/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(clientTest.getFirstName())));
    }
}