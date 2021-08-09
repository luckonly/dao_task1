package ru.netology.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers", schema = "netology")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private  String name;

    @Column(length = 40)
    private String surname;

    @Column(length = 3)
    private int age;

    @Column(name = "phone_number", length = 40)
    private String phoneNumber;

    @OneToMany(mappedBy = "id")
    private List<Order> orders;
}
