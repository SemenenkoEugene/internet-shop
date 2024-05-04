package ru.semenenko.internetshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.semenenko.internetshop.dto.ClientDto;
import ru.semenenko.internetshop.entity.Client;
import ru.semenenko.internetshop.exception.ClientAlreadyExistsException;
import ru.semenenko.internetshop.mapper.ClientMapper;
import ru.semenenko.internetshop.repository.ClientRepository;
import ru.semenenko.internetshop.service.ClientService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public ClientDto createClient(ClientDto clientDto) {

        Client client = ClientMapper.fromDto(clientDto);
        try {

            Client saveClient = clientRepository.save(client);
            return ClientMapper.toDto(saveClient);
        } catch (Exception e) {
            throw new ClientAlreadyExistsException("Клиент с таким номером телефона уже существует");
        }

    }
}
