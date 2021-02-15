package org.sopt.seminar8.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class ItemEntity {
    @Id
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private int price;
}
