package ru.semenenko.internetshop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.semenenko.internetshop.validation.ClientName;
import ru.semenenko.internetshop.validation.PhoneNumber;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;

    @NotNull(message = "Поле для ввода имени не должно быть пустым, повторите попытку")
    @ClientName
    private String firstname;

    @ClientName
    private String middlename;

    @NotNull(message = "Поле для ввода фамилии не должно быть пустым, повторите попытку")
    @ClientName
    private String lastname;

    @NotNull
    @Size(min = 10, max = 10, message = "Номер телефона должен содержать 10 цифр")
    @PhoneNumber(message = "Поле для ввода номера телефона должно содержать только цифры")
    private String phoneNumber;


}
