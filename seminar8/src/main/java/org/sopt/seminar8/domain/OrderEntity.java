package org.sopt.seminar8.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    //default fetch type = EAGER
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    CustomerEntity customer;

    //default fetch type = LAZY
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "order_id")
    List<OrderItemEntity> orderItem;
}
