package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    OrderEntity findOne(Long orderId);
    List<OrderEntity> findAll();
}
