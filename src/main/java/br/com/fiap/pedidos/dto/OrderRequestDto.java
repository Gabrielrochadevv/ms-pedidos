package br.com.fiap.pedidos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderRequestDto {
    @NotBlank
    private String clientName;

    @Schema(description = "Valor total do pedido", example = "25.75")
    @NotNull
    @Positive
    private BigDecimal value;
}
