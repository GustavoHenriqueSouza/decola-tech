package me.dio.decola_tech.service;

import me.dio.decola_tech.domain.model.Operation;

public interface OperationService {

    Operation findById(Long id);

    Operation create(Operation pperation);
}
