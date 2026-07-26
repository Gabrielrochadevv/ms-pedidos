package br.com.fiap.pedidos.dto;

import br.com.fiap.pedidos.model.Order;
import br.com.fiap.pedidos.model.DeliveryStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OrderResponseDto(
        Long orderNumber,
        String clientName,
        LocalDate orderDate,
        BigDecimal value,
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
