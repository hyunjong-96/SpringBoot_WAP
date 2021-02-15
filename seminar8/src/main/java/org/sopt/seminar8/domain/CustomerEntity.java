package org.sopt.seminar8.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private String name;
}
