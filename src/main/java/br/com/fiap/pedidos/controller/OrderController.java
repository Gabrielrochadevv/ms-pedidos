package br.com.fiap.pedidos.controller;

import br.com.fiap.pedidos.dto.OrderRequestDto;
import br.com.fiap.pedidos.dto.OrderResponseDto;
import br.com.fiap.pedidos.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Orders", description = "Endpoints para gerenciamento de pedidos")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private Environment environment;

    @PostMapping
    @Operation(summary = "Cria os pedidos")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido criado com sucesso"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Dados do pedido inválidos")
    })
    public OrderResponseDto create(@RequestBody @Valid OrderRequestDto orderDto) {
        return service.create(orderDto);
    }

    @PutMapping ("{orderNumber}")
    @Operation(
            summary = "Atualiza um pedido",
            description = "Atualiza os dados de um pedido existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido atualizado com sucesso"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados do pedido inválidos"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pedido não encontrado")
    })
    public OrderResponseDto update(@PathVariable Long orderNumber, @RequestBody OrderRequestDto orderDto) {
        return service.update(orderDto, orderNumber);
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Exclui um pedido",
            description = "Remove um pedido existente pelo número do pedido"
    )
    public void delete(@PathVariable Long orderNumber) {
        service.delete(orderNumber);
    }

    @GetMapping("{orderNumber}")
    @Operation(
            summary = "Busca o pedido pelo número",
            description = "Retorna os dados do pedido a partir do seu número"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido encontrado"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pedido não encontrado")
    })
    public ResponseEntity<OrderResponseDto> searchByOrderNumber(@PathVariable Long orderNumber) {
        return ResponseEntity.ok(service.searchByOrderNumber(orderNumber));
    }

    @GetMapping
    @Operation(
            summary = "Lista todos os pedidos",
            description = "Retorna todos os pedidos cadastrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Pedidos retornados com sucesso"
    )
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return ResponseEntity.ok(service.displayAllOrders());
    }

    @PatchMapping("/{id}/transport")
    @Operation(
            summary = "Atualiza o status de transporte do pedido",
            description = "Atualiza o status do pedido para indicar que ele foi encaminhado para transporte"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Status de transporte atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pedido não encontrado"
            )
    })
    public void putInTransport(@PathVariable @NotNull Long id) {
        service.putInTransport(id);
    }

    @GetMapping("/port")
    @Operation(
            summary = "Consulta a porta da aplicação",
            description = "Retorna a porta em que a instância atual da aplicação está executando")
    @ApiResponse(
            responseCode = "200",
            description = "Porta retornada com sucesso"
    )
    public ResponseEntity<String> getPort() {
        String port = environment.getProperty("local.server.port");
        String message = String.format("PORTA UTILIZADA NA REQUISIÇÃO: %s", port);
        return ResponseEntity.ok(message);
    }
}
