package org.sopt.seminar8.repository;

import org.sopt.seminar8.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Optional<Item> findById(int id);
    Iterable<Item> findByName(String name);
}
