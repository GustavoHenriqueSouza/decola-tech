package me.dio.decola_tech.controller;

import me.dio.decola_tech.domain.model.Operation;
import me.dio.decola_tech.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/operations")
public class OperationController {

    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation> findById(@PathVariable Long id) {
        var user = operationService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Operation> create(@RequestBody Operation operation) {
        var operationCreated = operationService.create(operation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(operationCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(operationCreated);
    }
}