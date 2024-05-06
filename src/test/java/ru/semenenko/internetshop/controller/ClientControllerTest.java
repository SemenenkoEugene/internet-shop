package ru.semenenko.internetshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.semenenko.internetshop.dto.ClientDto;
import ru.semenenko.internetshop.service.impl.ClientServiceImpl;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClientServiceImpl clientService;

    @Test
    public void create_allValid() throws Exception {

        when(clientService.createClient(any())).thenReturn(null);

        mockMvc.perform(post("/api/v1/clients")
                        .content(objectMapper.writeValueAsString(clientValidDto()))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        verify(clientService, times(1)).createClient(any());
        verifyNoMoreInteractions(clientService);
    }

    @Test
    public void getClientPhoneNumber_allValid() throws Exception {
        when(clientService.getClientPhoneNumber(any(String.class))).thenReturn(clientValidDto());

        mockMvc.perform(get("/api/v1/clients/{clientPhoneNumber}", "0123456789")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        verify(clientService, times(1)).getClientPhoneNumber(any());
        verifyNoMoreInteractions(clientService);
    }


    private ClientDto clientValidDto() {
        return ClientDto.builder()
                .firstname("Клиент")
                .middlename("Клиентович")
                .lastname("Клиентов")
                .phoneNumber("0123456789")
                .build();
    }

}