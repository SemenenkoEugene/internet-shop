package ru.semenenko.internetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.semenenko.internetshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}