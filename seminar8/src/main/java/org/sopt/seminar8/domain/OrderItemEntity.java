package org.sopt.seminar8.domain;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItemEntity {
    @Id
    @Column(name = "order_line_id")
    private Long orderLineId;

    //default fetch type = EAGER
    @ManyToOne
    @JoinColumn(name = "item_id")
    ItemEntity item;
}
