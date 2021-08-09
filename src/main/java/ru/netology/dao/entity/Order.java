package ru.netology.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders", schema = "netology")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime date;

    @Column(name = "product_name")
    private String productName;

    @Column
    private int amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
