package me.dio.decola_tech.service.impl;

import me.dio.decola_tech.domain.model.Operation;
import me.dio.decola_tech.domain.model.Product;
import me.dio.decola_tech.domain.repository.OperationRepository;
import me.dio.decola_tech.domain.repository.ProductRepository;
import me.dio.decola_tech.service.OperationService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    private final ProductRepository productRepository;

    public OperationServiceImpl(OperationRepository operationRepository, ProductRepository productRepository) {
        this.operationRepository = operationRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Operation findById(Long id) {
        return operationRepository.findById(id).orElseThrow(NoSuchElementException::new);

    }

    @Override
    public Operation create(Operation operation) {
        if (operation.getProduct().getId() != null) {
            Product product = productRepository.findById(operation.getProduct().getId()).orElseThrow();
            operation.setProduct(product);
        }
        return operationRepository.save(operation);
    }
}
