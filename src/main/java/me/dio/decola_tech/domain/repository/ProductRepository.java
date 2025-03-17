package me.dio.decola_tech.domain.repository;

import me.dio.decola_tech.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
