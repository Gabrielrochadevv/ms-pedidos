package br.com.fiap.pedidos.dto;

import br.com.fiap.pedidos.domain.Order;
import br.com.fiap.pedidos.domain.DeliveryStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OrderResponseDto(
        Long orderNumber,
        String clientName,
        LocalDate orderDate,
        @Schema(description = "Valor total do pedido", example = "25.75")
        BigDecimal value,
        @Schema(description = "Status atual do pedido", example = "EM_SEPARACAO")
        DeliveryStatus deliveryStatus
) {
    public OrderResponseDto(Order order) {
        this(
                order.getOrderNumber(),
                order.getClientName(),
                order.getOrderDate(),
                order.getValue(),
                order.getDeliveryStatus()
        );
    }
}
