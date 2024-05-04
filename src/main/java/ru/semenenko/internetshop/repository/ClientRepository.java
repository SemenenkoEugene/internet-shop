package ru.semenenko.internetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.semenenko.internetshop.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
