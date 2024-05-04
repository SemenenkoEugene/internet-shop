package ru.semenenko.internetshop.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.semenenko.internetshop.dto.ClientDto;
import ru.semenenko.internetshop.entity.Client;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientMapper {

    public static ClientDto toDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstname(client.getFirstname())
                .middlename(client.getMiddlename())
                .lastname(client.getLastname())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }

    public static Client fromDto(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstname(clientDto.getFirstname());
        client.setMiddlename(clientDto.getMiddlename());
        client.setLastname(clientDto.getLastname());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return client;
    }
}
