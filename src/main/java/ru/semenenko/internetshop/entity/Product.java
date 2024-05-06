package ru.semenenko.internetshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name_product", nullable = false)
    private String name;

    @Column(name = "price_product", nullable = false)
    private Double price;

    @Column(name = "amount_product", nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "type_product_id")
    private TypeProduct typeProduct;
}
