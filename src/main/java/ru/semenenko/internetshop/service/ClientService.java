package ru.semenenko.internetshop.service;

import ru.semenenko.internetshop.dto.ClientDto;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientPhoneNumber(String clientPhoneNumber);
}
