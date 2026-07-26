package br.com.fiap.pedidos.dto;

import br.com.fiap.pedidos.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class OrderRequestDto {

    private Long orderNumber;
    private String clientName;
    private LocalDate orderDate;
    private BigDecimal value;
    private DeliveryStatus deliveryStatus;

}
