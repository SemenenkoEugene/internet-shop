package ru.semenenko.internetshop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.semenenko.internetshop.dto.ClientDto;
import ru.semenenko.internetshop.service.ClientService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@Valid @RequestBody ClientDto clientDto) {
        log.info("Получен запрос на создание нового клиента {}", clientDto);
        ClientDto createClient = clientService.createClient(clientDto);
        log.info("Создан новый клиент {}", createClient);
        return createClient;
    }
}
