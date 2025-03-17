package me.dio.decola_tech.domain.repository;

import me.dio.decola_tech.domain.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
