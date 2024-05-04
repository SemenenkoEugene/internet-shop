package ru.semenenko.internetshop.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.semenenko.internetshop.dto.ClientDto;
import ru.semenenko.internetshop.entity.Client;
import ru.semenenko.internetshop.exception.ClientAlreadyExistsException;
import ru.semenenko.internetshop.repository.ClientRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void createClient_whenIsOk() {
        ClientDto clientDto = ClientDto.builder().build();

        when(clientRepository.save(any(Client.class))).thenReturn(new Client());

        clientService.createClient(clientDto);

        verify(clientRepository, times(1)).save(any(Client.class));
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    public void createClient_testClientAlreadyExistsException() {
        ClientDto clientDto = ClientDto.builder()
                .phoneNumber("0123456789")
                .build();
        Client client = new Client();
        client.setPhoneNumber("0123456789");

        when(clientRepository.save(any(Client.class)))
                .thenThrow(new ClientAlreadyExistsException("Клиент с таким номером телефона уже существует"));
        ClientAlreadyExistsException exception =
                Assertions.assertThrows(ClientAlreadyExistsException.class, () -> clientService.createClient(clientDto));

        Assertions.assertEquals("Клиент с таким номером телефона уже существует", exception.getMessage());
    }

}