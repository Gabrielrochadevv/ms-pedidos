package br.com.fiap.pedidos.controller;

import br.com.fiap.pedidos.dto.OrderRequestDto;
import br.com.fiap.pedidos.dto.OrderResponseDto;
import br.com.fiap.pedidos.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private Environment environment;


    @PostMapping
    public OrderResponseDto create(@RequestBody @Valid OrderRequestDto orderDto) {
        return service.create(orderDto);
    }

    @PutMapping
    public OrderResponseDto update(@RequestBody OrderRequestDto orderDto) {
        return service.update(orderDto);
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long orderNumber) {
        service.delete(orderNumber);
    }

    @GetMapping("{orderNumber}")
    public ResponseEntity<OrderResponseDto> searchByOrderNumber(@PathVariable Long orderNumber) {
        return ResponseEntity.ok(service.searchByOrderNumber(orderNumber));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> displayAllOrders() {
        return ResponseEntity.ok(service.displayAllOrders());
    }

    @PatchMapping("/{id}/transport")
    public void putInTransport(@PathVariable @NotNull Long id) {
        service.putInTransport(id);
    }

    @GetMapping("/port")
    public ResponseEntity<String> displayPort() {
        String port = environment.getProperty("local.server.port");
        String message = String.format("PORTA UTILIZADA NA REQUISIÇÃO: %s", port);
        return ResponseEntity.ok(message);
    }


}
